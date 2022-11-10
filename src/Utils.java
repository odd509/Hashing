import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Utils {

    private static final byte[] PRIVATE_KEY = "".getBytes(StandardCharsets.UTF_8);
    private static final byte[] INITIALIZATION_VECTOR = "".getBytes(StandardCharsets.UTF_8);

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

                String UserString = new String(decryptedUsers, StandardCharsets.UTF_8);
                String[] users = UserString.split("\n");
                for (String user : users) {
                    String[] userInfo = user.split(" ");
                    User newUser = new User(userInfo[0], userInfo[1]);
                    // adding the new user instance to the static user arraylist in DataBase class
                    DataBase.getUserDB().add(newUser);
                }

                String messageString = new String(decryptedMessages, StandardCharsets.UTF_8);
                String[] messages = messageString.split("\n");
                for (String message : messages) {
                    String[] messageInfo = message.split(" ");
                    int userIndex = 0;
                    for (User user : DataBase.getUserDB()) {
                        if (user.getUsername().equals(messageInfo[3])) {
                            userIndex = DataBase.getUserDB().indexOf(user);
                            break;
                        }
                        ;
                    }
                    Message newMessage = new Message(messageInfo[0], messageInfo[1],
                            DataBase.getUserDB().get(userIndex), messageInfo[2]);
                    // adding the new message instance to the static message arraylist in DataBase
                    // class
                    DataBase.getMessageDB().add(newMessage);
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

        try {
            FileOutputStream messageOStream = new FileOutputStream(messageFile);
            FileOutputStream userOStream = new FileOutputStream(userFile);

            try {
                Cipher cipher = Cipher.getInstance("TripleDES/CBC/PKCS5Padding");
                SecretKey key = new SecretKeySpec(PRIVATE_KEY, "TripleDES");
                IvParameterSpec ivSpec = new IvParameterSpec(INITIALIZATION_VECTOR);
                cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);

                // encrypting and writing the message data file down
                for (Message message : DataBase.getMessageDB()) {
                    String stringToWrite = message.getMessageID() + " " + message.getMessageContent() + " "
                            + message.getHashedPassword() + " " + message.getReceivingUser().getUsername() + "\n";
                    byte[] messageArr = stringToWrite.getBytes(StandardCharsets.UTF_8);
                    byte[] cipherArray = cipher.doFinal(messageArr);
                    messageOStream.write(cipherArray);
                }

                // encrypting and writing the user data file down
                for (User user : DataBase.getUserDB()) {
                    String stringToWrite = user.getUsername() + " " + user.getHashedPassword() + "\n";
                    byte[] userArr = stringToWrite.getBytes(StandardCharsets.UTF_8);
                    byte[] cipherArray = cipher.doFinal(userArr);
                    userOStream.write(cipherArray);
                }
            } catch (IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException
                    | InvalidKeyException | InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            }

            messageOStream.flush();
            messageOStream.close();

            userOStream.flush();
            userOStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
