package io.olen4ixxx.composite.exception;

public class CustomCompositeException extends Exception {
    public CustomCompositeException(String message) {
        super(message);
    }

    public CustomCompositeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomCompositeException() {
    }

    public CustomCompositeException(Throwable cause) {
        super(cause);
    }
}
