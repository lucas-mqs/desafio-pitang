package com.pitang.desafio.lucasmarques.exceptions;

public class InvalidTokenException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidTokenException() {
        super();
    }

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(Throwable cause) {
        super(cause);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(message, cause);
    }

}
