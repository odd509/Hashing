package Backend;

/**
 * This exception is thrown when the user enters a username or a message ID that
 * is not unique.
 */
public class NotAUniqueFieldException extends Exception {

    public NotAUniqueFieldException(String errorMessage) {
        super(errorMessage);
    }
}
