package Exception;

public class NoThisRemarkException extends Exception {
    public NoThisRemarkException() {
    }

    public NoThisRemarkException(String message) {
        super(message);
    }

    public NoThisRemarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoThisRemarkException(Throwable cause) {
        super(cause);
    }

    public NoThisRemarkException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
