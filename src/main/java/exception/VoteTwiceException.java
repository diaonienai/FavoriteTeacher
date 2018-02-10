package exception;

public class VoteTwiceException extends BaseException {
    public VoteTwiceException(String message) {
        super(message);
    }

    public VoteTwiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
