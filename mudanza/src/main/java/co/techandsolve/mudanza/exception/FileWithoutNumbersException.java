package co.techandsolve.mudanza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FileWithoutNumbersException extends RuntimeException {

    public FileWithoutNumbersException(String message) {
        super(message);
    }
}
