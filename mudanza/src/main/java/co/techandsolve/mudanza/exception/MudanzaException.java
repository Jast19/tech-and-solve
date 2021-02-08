package co.techandsolve.mudanza.exception;

public class MudanzaException extends RuntimeException {
    public MudanzaException(String message) {
        super(message);
    }

    public MudanzaException(String message, Throwable cause) {
        super(message, cause);
    }
}
