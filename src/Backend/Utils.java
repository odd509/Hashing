package Backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.sound.sampled.SourceDataLine;

public class Utils {

    private static final byte[] PRIVATE_KEY = Arrays.copyOf("ouz".getBytes(StandardCharsets.UTF_8), 24);
    private static final byte[] INITIALIZATION_VECTOR = Arrays.copyOf("sema".getBytes(StandardCharsets.UTF_8), 8);

    /**
     * Reads and decrypts the data files, creates the message and user objects and
     * adds them to the appropriate
     * static arraylists in the DataBase class.
     */
    public static void importData() {
        File messageFile = new File("messageFile.data");
        File userFile = new File("userFile.data");

        try {
            FileInputStream messageIStream = new FileInputStream(messageFile);
            FileInputStream userIStream = new FileInputStream(userFile);

            // reading the encrypted binary data
            byte[] messageCipherArr = new byte[(int) messageFile.length()];
            messageIStream.read(messageCipherArr);

            byte[] userCipherArr = new byte[(int) userFile.length()];
            userIStream.read(userCipherArr);

            try {
                Cipher cipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
                SecretKey key = new SecretKeySpec(PRIVATE_KEY, "TripleDES");
                IvParameterSpec ivSpec = new IvParameterSpec(INITIALIZATION_VECTOR);
                cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);

                // decrypting the data
                byte[] decryptedMessages = cipher.doFinal(messageCipherArr);
                byte[] decryptedUsers = cipher.doFinal(userCipherArr);

                String userString = new String(decryptedUsers, StandardCharsets.UTF_8);
                if (userString.length() != 0) {
                    System.out.println(userString);
                    String[] users = userString.split("_");
                    System.out.println(users.length);
                    for (String user : users) {
                        String[] userInfo = user.split("-");
                        new User(userInfo[0], userInfo[1]);
                    }
                }

                String messageString = new String(decryptedMessages, StandardCharsets.UTF_8);
                if (messageString.length() != 0) {
                    String[] messages = messageString.split("_");
                    for (String message : messages) {
                        String[] messageInfo = message.split("-");
                        new Message(messageInfo[0], messageInfo[1], DataBase.findUser(messageInfo[3]), messageInfo[2]);
                    }
                }

            } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException
                    | InvalidKeyException | InvalidAlgorithmParameterException | NotAUniqueFieldException e) {
                e.printStackTrace();
            }

            messageIStream.close();

            userIStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the stored info in the lists to the data files in bytes. The data is
     * encrypted using the
     * java crypto API "DESede/CBC/PKCS5Padding" mode.
     */
    public static void exportData() {
        File messageFile = new File("messageFile.data");
        File userFile = new File("userFile.data");
        messageFile.delete();
        userFile.delete();

        try {
            FileOutputStream messageOStream = new FileOutputStream(messageFile, false);
            FileOutputStream userOStream = new FileOutputStream(userFile, false);

            try {
                Cipher cipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
                SecretKey key = new SecretKeySpec(PRIVATE_KEY, "TripleDES");
                IvParameterSpec ivSpec = new IvParameterSpec(INITIALIZATION_VECTOR);
                cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

                // encrypting and writing the message data file down
                String stringToWrite = "";
                for (Message message : DataBase.getMessageDB()) {
                    stringToWrite += message.getMessageID() + "-" + message.getMessageContent() + "-"
                            + message.getHashedPassword() + "-" + message.getReceivingUser().getUsername() + "_";
                }
                byte[] messageArr = stringToWrite.getBytes(StandardCharsets.UTF_8);
                byte[] cipherArray = cipher.doFinal(messageArr);
                messageOStream.write(cipherArray);

                stringToWrite = "";

                // encrypting and writing the user data file down
                for (User user : DataBase.getUserDB()) {
                    stringToWrite += user.getUsername() + "-" + user.getHashedPassword() + "_";

                }

                byte[] userArr = stringToWrite.getBytes(StandardCharsets.UTF_8);
                cipherArray = cipher.doFinal(userArr);
                userOStream.write(cipherArray);

            } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException
                    | InvalidKeyException | InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            }

            messageOStream.close();

            userOStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Checks if the given messageID and password matches by checking the hashes.
     * 
     * @param messageID
     * @param password
     * @return
     */
    public static boolean checkMessageHash(String messageID, String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
            if (DataBase.findMessage(messageID).getHashedPassword().equals(hashedPassword)) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Checks if the given messageID and password matches by checking the hashes.
     * 
     * @param username
     * @param password
     * @return
     */
    public static boolean checkUserHash(String username, String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
            if (DataBase.findUser(username).getHashedPassword().equals(hashedPassword)) {
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}
