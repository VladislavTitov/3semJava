import Dao.FileBasedUsersDaoImpl;
import Dao.User;

public class Main {
    public static void main(String[] args) {
        FileBasedUsersDaoImpl test = new FileBasedUsersDaoImpl();
        test.save(new User("NewUser32324", 12345));
    }
}
