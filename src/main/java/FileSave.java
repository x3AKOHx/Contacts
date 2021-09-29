import java.io.*;
import java.util.ArrayList;

public class FileSave {

    public static void loadFromFile(String str, PhoneBook phoneBook) {
        if (!str.equals("")) {
            try {
                File file = new File(str);
                file.createNewFile();
                if (file.length() > 0) {
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    ArrayList<Contacts> temp = (ArrayList<Contacts>) ois.readObject();
                    phoneBook.setContacts(temp);
                    ois.close();
                }
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveToFile(String str, ArrayList<Contacts> contacts) {
        if (!str.equals("")) {
            try {
                FileOutputStream fos = new FileOutputStream(str);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(contacts);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
