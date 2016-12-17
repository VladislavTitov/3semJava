package Dao;

import Models.User;

public interface UserDao2 {

    //TODO прикрутить SecurityUser (без пароля)
    /**
     * находит пользователя с заданным именем
     * @param userName имя пользователя
     */
    void find(String userName);

    //TODO прикруть SecurityUser обязон!
    /**
     * проверяет соответствие имя пользователя паролю
     * @param userName имя пользователя
     * @param password пароль в обычно виде (преобразуется в хэш внутри метода)
     * @return модель без пароля, но с именем, если соответствует, без имении, если нет
     */
    String checkPassword(String userName, String password);

    /**
     * сохраняет пользователя, генерируя хэш для пароля
     * @param user модель нового пользователя
     */
    void save(User user);

    /**
     * обновляет пользователя
     * @param user модель пользователя с обновленными данными
     */
    void update(User user);

    /**
     * удаляет пользователя (т.е. аккаунт) с заданным именем
     * @param userName
     */
    void delete(String userName);


}
