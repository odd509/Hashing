package Backend;

import java.util.ArrayList;

public class DataBase {

    // The list to store Message objects in for processing.
    private static ArrayList<Message> messageDB = new ArrayList<>();

    public static ArrayList<Message> getMessageDB() {
        return messageDB;
    }

    // The list to store User objects in for processing.
    private static ArrayList<User> userDB = new ArrayList<>();

    public static ArrayList<User> getUserDB() {
        return userDB;
    }

}
