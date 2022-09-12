package contacts.utility;

import java.io.*;

public class Serializator {

    public static void serialize(Object object, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutput oos = new ObjectOutputStream(bos);
        oos.writeObject(object);
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInput ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
