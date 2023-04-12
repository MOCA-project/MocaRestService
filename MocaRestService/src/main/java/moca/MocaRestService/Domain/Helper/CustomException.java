package moca.MocaRestService.Domain.Helper;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final LocalDateTime localDateTime;
    private final int statusCode;

    public CustomException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.localDateTime = LocalDateTime.now();
        this.statusCode = httpStatus.value();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
