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

    /**
     * Method used to find the message object in the database using the ID.
     * 
     * @param messageID
     * @return
     */
    public static Message findMessage(String messageID) {
        for (Message message : messageDB) {
            if (message.getMessageID().equals(messageID)) {
                return message;
            }
        }
        return null;
    }

    /**
     * Method used to find the user object in the database using the username.
     * 
     * @param username
     * @return
     */
    public static User findUser(String username) {
        for (User user : userDB) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
