package utils;

/**
 * created by Andrey Melnichenko at 17:19 07-09-2018
 */

public class StringReformate {
    public static String cutString(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == ',') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
