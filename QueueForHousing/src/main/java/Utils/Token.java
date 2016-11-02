package Utils;

import java.util.Random;

public class Token {

    public static String generateToken(){

        char[] token = new char[50];
        Random random = new Random();

        for (int i = 0; i < token.length; i++) {
            int r = random.nextInt(3);
            if (r == 0){
                token[i] = (char) (random.nextInt(9) + 48);
            }else if (r == 1){
                token[i] = (char) (random.nextInt(25) + 65);
            }else {
                token[i] = (char) (random.nextInt(25) + 97);
            }
        }

        return String.valueOf(token);
    }

}
