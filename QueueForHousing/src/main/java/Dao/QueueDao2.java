package Dao;

import Models.*;

public interface QueueDao2 {
    /**
     * этот блок проверяет на существование записи в заданных таблицах для определенного пользователя
     * @param userName имя пользователя
     * @return существует или нет
     */
    boolean fatherIsExists(String userName);

    boolean motherIsExists(String userName);

    boolean childrenIsExists(String userName);

    boolean childIsExists(String userName, Child child);

    boolean wishesIsExists(String userName);

    boolean housingIsExists(String userName);

    boolean queueIsExists(String userName);

    /**
     * записывает в таблицу Father модель Father (остальные методы аналогичны)
     * @param userName имя пользователя
     * @param father модель отца
     */
    void saveFather(String userName, Father father);

    void saveMother(String userName, Mother mother);

    void saveChild(String userName, Child child);

    void saveWishes(String userName, Wishes wishes);

    void saveHousing(String userName, Housing housing);

    void saveQueue(String userName, Queue queue);

    /**
     * обновляет данные в таблице Father для определенного пользователя (остальные методы аналогичны)
     * @param userName имя пользователя
     * @param father модель отца
     */
    void updateFather(String userName, Father father);

    void updateMother(String userName, Mother mother);

    void updateChild(String userName, Child child);

    void updateWishes(String userName, Wishes wishes);

    void updateHousing(String userName, Housing housing);

    void updateQueue(String userName, Queue queue);


    /**
     * методы удаляют записи из таблиц для определенного пользователя
     * @param userName имя пользователя
     */
    void deleteFather(String userName);

    void deleteMother(String userName);

    void deleteChild(String userName, Child child);

    void deleteChildren(String userName);

    void deleteWishes(String userName);

    void deleteHousing(String userName);

    void deleteQueue(String userName);

}
