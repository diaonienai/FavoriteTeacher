package exception;

public class TeaNotFoundException extends BaseException {
    public TeaNotFoundException(String message) {
        super(message);
    }

    public TeaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
