package Dao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    UserDao userDao;
    //ResultSet set;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDaoImpl();
        /*set = Mockito.mock(ResultSet.class);
        Mockito.when(set.next()).thenReturn(true).thenReturn(true);*/
    }

    @Test
    public void checkPassword() throws Exception {
        assertTrue(userDao.checkPassword("admin2@admin2.com", "123"));
    }

}