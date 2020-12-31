package com.word.select.exception.domain;

public class WordSelectException extends RuntimeException {

    private String message;
    private String details;

    public WordSelectException(
            String message, String details) {
        this.message = message;
        this.details = details;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
