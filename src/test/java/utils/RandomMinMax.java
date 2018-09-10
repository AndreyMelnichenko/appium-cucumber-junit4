package utils;

import java.util.Random;

/**
 * created by Andrey Melnichenko at 19:20 10-09-2018
 */

public class RandomMinMax {
    public static int Go (int min, int max){
        Random random = new Random();
        return random.nextInt((max - min + 1) + min);
    }
}
