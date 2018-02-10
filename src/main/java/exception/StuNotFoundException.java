package exception;

public class StuNotFoundException extends BaseException {
    public StuNotFoundException(String message) {
        super(message);
    }

    public StuNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
