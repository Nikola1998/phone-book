package contacts.utility;

import java.io.*;

public class Serializer {

    public static void serialize(Object object, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutput oos = new ObjectOutputStream(bos)) {
            oos.writeObject(object);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInput ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
