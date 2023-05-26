package de.atruvia.collections;

public class ArrayFillerException extends RuntimeException{

    public ArrayFillerException() {
    }

    public ArrayFillerException(final String message) {
        super(message);
    }

    public ArrayFillerException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ArrayFillerException(final Throwable cause) {
        super(cause);
    }

    public ArrayFillerException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
