package co.techandsolve.mudanza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class MudanzaException extends RuntimeException {
    public MudanzaException(String message) {
        super(message);
    }
}
