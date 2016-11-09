package Dao;

import Factories.DaoFactory;
import Models.Child;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueueDaoImplTest {

    QueueDao queueDao;
    ArrayList<Child> childrenTest;

    @Before
    public void setUp() throws Exception {
        queueDao = DaoFactory.getInstance().getQueueDao();
        childrenTest = Mockito.mock(ArrayList.class);
        Mockito.when(childrenTest.get(0)).thenReturn(new Child.Builder().setSurname("Titov").setName("Vladislav").setPatronymic("Sergeevich").build());
        Mockito.when(childrenTest.size()).thenReturn(1);
    }

    @Test
    public void saveChildren() throws Exception {
        int expected = 4;
        assertEquals(expected, (long)queueDao.saveChildren(childrenTest, 1, 1)[0]);

    }

}