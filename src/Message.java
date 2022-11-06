import java.util.HashSet;

public class Message {

    // The set to store unique message IDs in.
    private static HashSet<String> messageIDs = new HashSet<>();

    private String messageID;
    private String messageContent;
    private User receivingUser;
    private String hashedMessagePassword;

    /**
     * Instantiates the class with its properties including its unique message ID.
     * 
     * @param messageID
     * @param messageContent
     * @param receivingUser
     * @param hashedMessagePassword
     * @throws NotAUniqueFieldException
     */
    public Message(String messageID, String messageContent, User receivingUser, String hashedMessagePassword)
            throws NotAUniqueFieldException {
        if (messageIDs.contains(messageID)) {
            throw new NotAUniqueFieldException("This message ID exists: " + messageID);
        }
        this.messageID = messageID;
        messageIDs.add(messageID);
        this.messageContent = messageContent;
        this.receivingUser = receivingUser;
        this.hashedMessagePassword = hashedMessagePassword;

    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public User getReceivingUser() {
        return receivingUser;
    }

    public String getHashedPassword() {
        return hashedMessagePassword;
    }

}
