package exception;

public class MsgRepeatException extends BaseException {
    public MsgRepeatException(String message) {
        super(message);
    }

    public MsgRepeatException(String message, Throwable cause) {
        super(message, cause);
    }
}
