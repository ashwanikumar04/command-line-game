package in.ashwanik.clgame.utils;

import in.ashwanik.clgame.messaging.EventBus;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class FileUtils {
    public static String getBasePath() {
        return EventBus.getInstance().getClass().getProtectionDomain().getCodeSource().getLocation().toString() + File.pathSeparator + "data";
    }

    public static void createBasePath() {
        String path = getBasePath();
        File file = new File(path);
        if (!file.isDirectory()) {
            file.mkdir();
        }
    }

    public static String getLatestFile() {
        String path = getBasePath();

        File file = new File(path);
        if (file.isDirectory()) {
            String[] files = file.list();
            if (!Objects.isNull(files)) {
                Arrays.sort(files);
                return files[files.length - 1];
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
