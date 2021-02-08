package co.techandsolve.mudanza.handler;

import co.techandsolve.mudanza.exception.FileWithoutNumbersException;
import co.techandsolve.mudanza.exception.MudanzaException;
import co.techandsolve.mudanza.exception.MudanzaExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MudanzaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MudanzaException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> mudanzaExceptions(Exception exception, WebRequest request) {
        MudanzaExceptionResponse response = new MudanzaExceptionResponse(exception.getMessage(),
                request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(FileWithoutNumbersException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> fileExceptions(Exception exception, WebRequest request) {
        MudanzaExceptionResponse response = new MudanzaExceptionResponse(exception.getMessage(),
                request.getDescription(false),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
