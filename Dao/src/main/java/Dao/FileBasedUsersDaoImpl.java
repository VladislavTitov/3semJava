package Dao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class FileBasedUsersDaoImpl implements UsersDao{

    public List<User> findAll() {
        List<User> users = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Vladislav\\IdeaProjects\\Dao\\src\\main\\resources\\Users.txt"))) {

            String user_string;
            while ((user_string = reader.readLine())!=null) {
                User newUser = new User(user_string.substring(0, user_string.indexOf(' ')), Integer.parseInt(user_string.substring(user_string.indexOf(' ') + 1)));
                users.add(newUser);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int save(User user) {

        try /*(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Vladislav\\IdeaProjects\\Dao\\src\\main\\resources\\Users.txt")))*/ {
            //writer.write(user.getName() + " " + user.getId()+ "\n");
            String record = user.getName() + " " + user.getId()+ "\n";
            Files.write(Paths.get("Users.txt"), record.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User find(int id) {
        User user = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Vladislav\\IdeaProjects\\Dao\\src\\main\\resources\\Users.txt"))) {

            String user_string;
            while ((user_string = reader.readLine())!=null) {
                if (id == Integer.parseInt(user_string.substring(user_string.indexOf(' ') + 1))){
                    user = new User(user_string.substring(0, user_string.indexOf(' ')), Integer.parseInt(user_string.substring(user_string.indexOf(' ') + 1)));
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
