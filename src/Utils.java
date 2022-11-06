import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
     * Writes the stored info in the lists to the data files in bytes. The data is
     * encrypted using the
     * java crypto API "DESede/CBC/PKCS5Padding" mode.
     */
    public static void export() {
        File messageFile = new File("messageFile.data");
        File userFile = new File("userFile.data");

        try {
            FileOutputStream messageOStream = new FileOutputStream(messageFile);
            FileOutputStream userOStream = new FileOutputStream(userFile);

            try {
                Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
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
