package moca.MocaRestService.Configuration.ExceptionHandler;

import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private int statusCode;
    private LocalDateTime dateTime;
    private String statusReason;

    public ErrorResponse(String message, int statusCode, LocalDateTime dateTime, String statusReason) {
        this.message = message;
        this.statusCode = statusCode;
        this.dateTime = dateTime;
        this.statusReason = statusReason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
}

