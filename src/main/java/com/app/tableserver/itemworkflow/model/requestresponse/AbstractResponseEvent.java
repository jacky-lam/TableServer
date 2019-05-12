package com.app.tableserver.itemworkflow.model.requestresponse;

import org.springframework.http.HttpStatus;

public abstract class AbstractResponseEvent {

    private int status;
    private final String statusCode;

    private final String message;

    public AbstractResponseEvent(HttpStatus httpStatus, String message){
        this.status = httpStatus.value();
        this.statusCode = httpStatus.getReasonPhrase();
        this.message = message;
    }

    public AbstractResponseEvent(int status, String statusCode, String message){
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}
