package Services;

import Models.User;

public interface UserService2 {

    /**
     * проверяем, зарегистрирован ли пользователь в системе
     * @param userName имя пользователя, введенное в поле ввода в форме входа или регистрации
     * @return зарегистрирован или нет
     */
    boolean isRegistered(String userName);

    /**
     * проверям пароль для конкретного пользователя
     * @param userName имя пользователя
     * @param password пароль, введенный в поле ввода в форме входа
     * @return соответствует пароль или нет пользователю
     */
    boolean checkPassword(String userName, String password);

    /**
     * сохраняем пользователя, пароль и дату регистрации в бд
     * @param user модель пользователя
     */
    void save(User user);

    //TODO при реализации поставить заглушку (не реализовано обновление)
    /**
     * обновляет данные пользователя
     * @param user модель пользователя
     */
    void update(User user);

    /**
     * удаляет пользователя, т.е. и аккаунт, и все параметры
     * @param userName имя пользователя, чей аккаунт подлежит удалению
     */
    void delete(String userName);

}
