package db.app.exception;

@SuppressWarnings("serial")
public class MensajeErrorException extends Exception {
    public MensajeErrorException() {
        super();
    }

    public MensajeErrorException(String s) {
        super(s);
    }

}
