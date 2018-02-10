package exception;

public class MsgLengthException extends BaseException {
    public MsgLengthException(String message) {
        super(message);
    }

    public MsgLengthException(String message, Throwable cause) {
        super(message, cause);
    }
}
