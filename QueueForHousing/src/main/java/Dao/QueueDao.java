package Dao;

import Models.*;

import java.util.ArrayList;

public interface QueueDao {

    /**
     * Work with db: saving param children in Children table using fatherId and motherId
     * @param children
     * @param fatherId
     * @param motherId
     * @return array of children's ids
     */
    int[] saveChildren(ArrayList<Child> children, int fatherId, int motherId);

    /**
     * Work with db: saving Father in Father table
     * @param father
     * @return father's id
     */
    int saveFather(Father father);

    int saveMother(Mother mother);

    int saveFamily(int fatherId, int motherId);

    int saveWishes(Wishes wishes);

    int saveHousing(Housing housing, int familyId, int wishesId);

    int saveQueue(Queue queue, int familyId, int housingId);

    boolean queueExist(String userName);

    String findFather(String userName);

    String findMother(String userName);

    String findChildren(String userName);

    /*int findPlaceInQueue(String userName);*/

    int findId(String userName);

}
