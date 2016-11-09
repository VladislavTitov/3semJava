package Dao;

import Factories.ConnectionToDb;
import Models.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueueDaoImpl implements QueueDao {
    @Override
    public int[] saveChildren(ArrayList<Child> children, int fatherId, int motherId) {

        int[] childrenIds = new int[children.size()];
        for (int i = 0; i < childrenIds.length; i++) {
            childrenIds[i] = -1;
        }

        try {
            for (int i = 0; i < childrenIds.length; i++) {
                PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                        "INSERT INTO \"Children\" VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING child_id;"
                );

                statement.setString(1, children.get(i).getSurname());
                statement.setString(2, children.get(i).getName());
                statement.setString(3, children.get(i).getPatronymic());
                statement.setInt(4, fatherId);
                statement.setInt(5, motherId);

                ResultSet rs = statement.executeQuery();

                if (rs.next()){
                    childrenIds[i] = rs.getInt("child_id");
                }
                if (rs.next()){
                    throw new IllegalArgumentException("Returned 2 children on one iteration in saveChildren");
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }


        return childrenIds;
    }

    @Override
    public int saveFather(Father father) {

        int fatherId = -1;

        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO \"Father\" VALUES (DEFAULT, ?, ?, ?) RETURNING father_id;"
            );

            statement.setString(1, father.getSurname());
            statement.setString(2, father.getName());
            statement.setString(3, father.getPatronymic());

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                fatherId = rs.getInt("father_id");
            }
            if (rs.next()){
                throw new IllegalArgumentException("There is 2 father ids returned in saveFather()");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fatherId;
    }

    @Override
    public int saveMother(Mother mother) {
        int motherId = -1;

        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO \"Mother\" VALUES (DEFAULT, ?, ?, ?) RETURNING mother_id;"
            );

            statement.setString(1, mother.getSurname());
            statement.setString(2, mother.getName());
            statement.setString(3, mother.getPatronymic());

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                motherId = rs.getInt("mother_id");
            }
            if (rs.next()){
                throw new IllegalArgumentException("There is 2 mother ids returned in saveMother()");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motherId;
    }

    @Override
    public int saveFamily(int fatherId, int motherId) {

        int familyId = -1;

        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO \"Family\" VALUES (DEFAULT, ?, ?) RETURNING family_id;"
            );

            statement.setInt(1, fatherId);
            statement.setInt(2, motherId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                familyId = rs.getInt("family_id");
            }
            if (rs.next()){
                throw new IllegalArgumentException("Returned 2 family ids in saveFamily()");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return familyId;
    }

    @Override
    public int saveWishes(Wishes wishes) {
        int wishesId = -1;
        try{
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO \"Wishes\" VALUES (DEFAULT, ?, ?, ?, ?) RETURNING wish_id;"
            );

            statement.setInt(1, wishes.getRoomsCount());
            statement.setBoolean(2, wishes.isKindergarden());
            statement.setBoolean(3, wishes.isSchool());
            statement.setString(4, wishes.getDistrict());

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                wishesId = rs.getInt("wish_id");
            }
            if (rs.next()){
                throw new IllegalArgumentException("Returned 2 wish ids in saveWishes()");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return wishesId;
    }

    @Override
    public int saveHousing(Housing housing, int familyId, int wishesId) {
        int housingId = -1;
        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO \"Housing\" VALUES (DEFAULT, ?, ?, ?) RETURNING housing_id;"
            );

            statement.setInt(1, familyId);
            statement.setInt(2, housing.getCondition());
            statement.setInt(3, wishesId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                housingId = rs.getInt("housing_id");
            }
            if (rs.next()){
                throw new IllegalArgumentException("Returned 2 housing ids in saveHousing()");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return housingId;
    }

    @Override
    public int saveQueue(Queue queue, int familyId, int housingId) {
        int queueId = -1;
        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "INSERT INTO \"Queue\" VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING queue_id;"
            );

            statement.setInt(1, familyId);
            statement.setInt(2, housingId);
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            statement.setBoolean(4, queue.isPromotions());
            statement.setBoolean(5, queue.isOutOfQueue());
            statement.setBoolean(6, queue.isFirstOfQueue());

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                queueId = rs.getInt("queue_id");
            }
            if (rs.next()){
                throw new IllegalArgumentException("Returned 2 queue ids in saveQueue()");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return queueId;
    }

    @Override
    public boolean queueExist(String userName) {
        boolean isExist = false;
        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "SELECT queue_id FROM \"Users\" WHERE user_name = ?;"
            );
            statement.setString(1, userName);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                try {
                    if (rs.getInt("queue_id") != 0) {
                        isExist = true;
                    }
                }catch (NullPointerException ex){
                    System.out.println("If isExist = true then it don't work!");
                }
            }
            if (rs.next()){
                throw new IllegalArgumentException("Table Users contain 2 " + userName + " *from queueExist*");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isExist;
    }

    @Override
    public String findFather(String userName) {
        return null;
    }

    @Override
    public String findMother(String userName) {
        return null;
    }

    @Override
    public String findChildren(String userName) {
        return null;
    }

    @Override
    public int findId(String userName) {
        int userId = -1;

        try {
            PreparedStatement statement = ConnectionToDb.getInstance().getConnection().prepareStatement(
                    "SELECT user_id FROM \"Users\" WHERE user_name = ?;"
            );
            statement.setString(1, userName);

            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                userId = rs.getInt("user_id");
            }
            if (rs.next()){
                throw new IllegalArgumentException("Table Users contain 2 " + userName + " *from findId*");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return userId;
    }
}
