package in.ashwanik.clgame.utils;

import java.util.Objects;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class StringUtils {
    public static boolean isBlank(String text) {
        return Objects.isNull(text) || text.trim().length() == 0;
    }

    public static boolean isNotLowercase(String string) {
        for (char c : string.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
