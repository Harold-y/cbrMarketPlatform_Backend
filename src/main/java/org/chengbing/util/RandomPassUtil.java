package org.chengbing.util;

import java.util.Random;

/**
 * @author Harold CI (Harold澂冰)
 * This is a Class that can Generate Random Passwords base on the Length Given
 */
public class RandomPassUtil {

    public static Integer length = 12;

    public static String randomPass(Integer length)
    {
        Random random = new Random();
        StringBuilder pass = new StringBuilder();
        boolean isNum;
        for(int i = 0 ; i < length; i ++)
        {
            int determinant = random.nextInt(10);
           isNum = random.nextBoolean();
            if(isNum)
                pass.append(determinant);
            else {
                int toAdd = random.nextInt(10);
                if(random.nextBoolean())
                {
                    char character = 'a';
                    character += toAdd;
                    pass.append(character);
                }else
                {
                    char character = 'A';
                    character += toAdd;
                    pass.append(character);
                }
            }
        }
        return pass.toString();
    }
}
