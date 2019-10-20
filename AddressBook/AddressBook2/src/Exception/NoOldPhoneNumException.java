package Exception;

public class NoOldPhoneNumException extends Exception {
    public NoOldPhoneNumException() {
    }

    public NoOldPhoneNumException(String message) {
        super(message);
    }

    public NoOldPhoneNumException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoOldPhoneNumException(Throwable cause) {
        super(cause);
    }

    public NoOldPhoneNumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
