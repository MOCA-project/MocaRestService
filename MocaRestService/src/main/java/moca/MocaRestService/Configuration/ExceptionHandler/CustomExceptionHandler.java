package moca.MocaRestService.Configuration.ExceptionHandler;

import moca.MocaRestService.Domain.Helper.CustomException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@ComponentScan
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        HttpStatus status = ex.getHttpStatus();
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage(),
                ex.getStatusCode(),
                ex.getLocalDateTime(),
                ex.getHttpStatus().getReasonPhrase()
        );
        return new ResponseEntity<>(errorResponse, status);
    }
}

