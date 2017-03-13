package com.limethecoder.pos.view;

/**
 * Part of MVC pattern that responsible for displaying information
 * for user
 */
public interface View {

    /** View message templates */
    String WRONG_INPUT = "Incorrect input data. Please repeat.";
    String INPUT_COIN = "Please inject coin. " +
            "System supports only 1, 5, 10, 25, 50 coin values.";

    /**
     * Displays message to user.
     *
     * @param message to display
     */
    void displayMessage(String message);

    /**
     * Performs formatting message with args and displays to user.
     *
     * @param message template for args substitution
     * @param args arguments to substitute in message
     */
    void displayMessage(String message, Object... args);
}
