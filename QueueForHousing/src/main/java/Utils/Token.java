package Utils;

import java.util.Random;

public class Token {

    public static String generateToken(){

        char[] token = new char[50];
        Random random = new Random();

        for (int i = 0; i < token.length; i++) {
            token[i] = (char) (random.nextInt(93) + 33);
        }

        return String.valueOf(token);
    }

}
