package com.app.tableserver.itemworkflow.model.requestresponse;

import org.springframework.http.HttpStatus;

//Error exception that was not expected by server
public class ErrorExceptionResponse extends AbstractResponseEvent {

    private String errorMessage;

    public ErrorExceptionResponse(HttpStatus httpStatus, String errorMessage) {
        super(httpStatus, errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
