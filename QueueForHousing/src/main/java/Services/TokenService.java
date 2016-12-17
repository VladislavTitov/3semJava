package Services;

public interface TokenService {

    /**
     * Здесь генерируем токен и сохраняем его в бд
     * @param userName имя пользователя, для которого генерируем токен
     * @return токен
     */
    String generateToken(String userName);

    /**
     * проверяем существование токена
     * @param token токен, пришедший с куками
     * @return существает ли: да или нет
     */
    boolean isExists(String token);

}
