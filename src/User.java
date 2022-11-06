import java.util.HashSet;

public class User {

    // The set to store unique usernames in.
    private static HashSet<String> usernames = new HashSet<>();

    private String username;
    private String hashedUserPassword;

    /**
     * Instantiates the class with its properties including its unique username.
     * 
     * @param username
     * @param hashedUserPassword
     * @throws NotAUniqueFieldException
     */
    public User(String username, String hashedUserPassword) throws NotAUniqueFieldException {
        if (usernames.contains(username)) {
            throw new NotAUniqueFieldException("This username exists: " + username);
        }
        this.username = username;
        usernames.add(username);
        this.hashedUserPassword = hashedUserPassword;
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
