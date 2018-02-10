package exception;

public class InsertException extends BaseException {
    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }
}
