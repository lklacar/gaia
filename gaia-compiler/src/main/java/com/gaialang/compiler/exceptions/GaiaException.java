package com.gaialang.compiler.exceptions;

public class GaiaException extends RuntimeException {

    public GaiaException() {
    }

    public GaiaException(String message) {
        super(message);
    }

    public GaiaException(String message, Throwable cause) {
        super(message, cause);
    }

    public GaiaException(Throwable cause) {
        super(cause);
    }

    public GaiaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
