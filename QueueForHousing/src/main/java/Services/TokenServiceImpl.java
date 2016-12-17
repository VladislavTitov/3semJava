package Services;

import Utils.Token;

public class TokenServiceImpl implements TokenService {

    //TODO инициализировать TokenDao

    public TokenServiceImpl() {

    }

    @Override
    public String generateToken(String userName) {
        String token = Token.generateToken();
        //TODO закинуть в бд токен через TokenDao
        return token;
    }

    @Override
    public boolean isExists(String token) {
        //TODO сделать запрос через TokenDao на поиск токена и обработать возращаемый список!!!
        return false;
    }
}
