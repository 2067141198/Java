package Exception;

public class YetBorrowException extends Exception {
    public YetBorrowException() {
    }

    public YetBorrowException(String message) {
        super(message);
    }

    public YetBorrowException(String message, Throwable cause) {
        super(message, cause);
    }

    public YetBorrowException(Throwable cause) {
        super(cause);
    }

    public YetBorrowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
