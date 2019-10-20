package Exception;

public class NoSuchLinkmanException extends Exception {
    public NoSuchLinkmanException() {
    }

    public NoSuchLinkmanException(String message) {
        super(message);
    }

    public NoSuchLinkmanException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchLinkmanException(Throwable cause) {
        super(cause);
    }

    public NoSuchLinkmanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
