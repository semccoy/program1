package program1;

import java.awt.*;
import java.util.Random;
import javalib.worldimages.*;

public class Utilities implements Constants {

    static String stringThings = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`~!@#$%^&*()-_=+[{]}|;:',<.>/?";

    public static int randomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static Color randomColor() {
        return new Color(randomInt(0, 255), randomInt(0, 255), randomInt(0, 255));
    }

    public static String randomString(int maxLength) {
        int length = new Random().nextInt(maxLength);
        StringBuilder newString = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            newString.append(stringThings.charAt(new Random().nextInt(stringThings.length())));
        }
        return newString.toString();
    }
}
