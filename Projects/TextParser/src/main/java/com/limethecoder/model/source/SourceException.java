package com.limethecoder.model.source;

/**
 * Class that describes exception, that occurs
 * in {@link Source} class methods.
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class SourceException extends Exception {
    public SourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SourceException(String message) {
        super(message);
    }

    public SourceException(Throwable cause) {
        super(cause);
    }
}
