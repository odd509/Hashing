package Backend;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashSet;

public class User {

    // The set to store unique usernames in.
    private static HashSet<String> usernames = new HashSet<>();

    private String username;
    private String hashedUserPassword;

    /**
     * Instantiates the class with its properties including its unique username and
     * hashes the password with SHA3-256 algorithm.
     * and then saves it.
     * 
     * @param username
     * @param userPassword
     * @throws NotAUniqueFieldException
     */
    public User(String username, String userPassword) throws NotAUniqueFieldException {
        if (usernames.contains(username)) {
            throw new NotAUniqueFieldException("This username exists: " + username);
        }

        try {
            // Hashing the given password string and converting it to base64 to represent it
            // as a string
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            byte[] hashedBytes = digest.digest(userPassword.getBytes(StandardCharsets.UTF_8));
            this.hashedUserPassword = Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        this.username = username;
        usernames.add(username);
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedUserPassword;
    }

    @Override
    public String toString() {
        return this.username;
    }
}
