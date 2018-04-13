package in.ashwanik.clgame.utils;

import java.io.*;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
public class SerializationUtil {
    public static boolean serialize(String fileName, Object data) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Object deserialize(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return inputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
