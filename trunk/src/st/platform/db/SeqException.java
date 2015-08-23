package  st.platform.db;

public class SeqException extends Exception {
    public SeqException(String message) {
        super(message);
    }

    public SeqException(String message, Throwable cause) {
        super(message, cause);
    }
}
