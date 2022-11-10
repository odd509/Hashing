import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashSet;

public class Message {

    // The set to store unique message IDs in.
    private static HashSet<String> messageIDs = new HashSet<>();

    private String messageID;
    private String messageContent;
    private User receivingUser;
    private String hashedMessagePassword;

    /**
     * Instantiates the class with its properties including its unique message ID
     * and hashes the
     * password with SHA3-256 algorithm.
     * 
     * @param messageID
     * @param messageContent
     * @param receivingUser
     * @param messagePassword
     * @throws NotAUniqueFieldException
     */
    public Message(String messageID, String messageContent, User receivingUser, String messagePassword)
            throws NotAUniqueFieldException {
        if (messageIDs.contains(messageID)) {
            throw new NotAUniqueFieldException("This message ID exists: " + messageID);
        }
        this.messageID = messageID;
        messageIDs.add(messageID);
        this.messageContent = messageContent;
        this.receivingUser = receivingUser;

        try {
            // Hashing the given password string and converting it to base64 to represent it
            // as a string
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            byte[] hashedBytes = digest.digest(messagePassword.getBytes(StandardCharsets.UTF_8));
            this.hashedMessagePassword = Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
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
