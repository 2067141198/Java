package Exception;

public class HadLinkmanException extends Exception{
    public HadLinkmanException() {
    }

    public HadLinkmanException(String message) {
        super(message);
    }

    public HadLinkmanException(String message, Throwable cause) {
        super(message, cause);
    }

    public HadLinkmanException(Throwable cause) {
        super(cause);
    }

    public HadLinkmanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
