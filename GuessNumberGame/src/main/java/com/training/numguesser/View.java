package com.training.numguesser;

import java.io.PrintStream;
import java.util.List;


/**
 * Part of MVC pattern that responsible for displaying information
 * for user
 *
 * @version 1.0 29 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see Model
 * @see Controller
 */
public class View {

    /* Block of message patterns, that will shown for user */

    public final static String INPUT_NUMBER = "Try to guess my number "
            + "(Press -1 to exit):";

    public final static String WRONG_INPUT =
            "Incorrect input data. Try again.";

    public final static String RANGE_HINT =
            "Guessed number is in range (%d - %d).";

    public final static String NOT_IN_RANGE =
            "Entered value not in given range. Try again!";

    public final static String STEPS_CNT = "You performed %d steps";

    public final static String GUESSED_VALUE = "Guessed number: %d";

    public final static String NEW_LINE = "\n";

    public final static String STEP_STATS =
            "At step %d you entered %d";

    public final static String WIN_CASE = "Congratz! You won!";

    public final static String LOOSE_CASE = "Try next time";

    public final static String INPUT_INT = "Input integer:";

    public final static String INPUT_LEFT_BOUNDARY =
            "Input left boundary of secret value range:";

    public final static String INPUT_RIGHT_BOUNDARY =
            "Input right boundary of secret value range:";

    public final static String WELCOME_MSG = "Welcome to the game!";

    public final static String INVALID_RANGE =
            "Invalid range. Use default values instead.";

    /** Stream to output information for user */
    private PrintStream stream;

    public View(PrintStream stream) {
        this.stream = stream;
    }

    /**
     * By mean of {@link #stream} print message, that passed as argument
     *
     * @param message information to print
     */
    public void printMessage(String message) {
        stream.println(message);
    }

    /**
     * By mean of {@link #stream} print hint for user
     * that number in this range
     *
     * @param min left boundary of range
     * @param max right boundary of range
     */
    public void printRangeMessage(int min, int max) {
        printMessage(String.format(RANGE_HINT, min, max));
    }

    /**
     * By mean of {@link #stream} print prompt for user
     * to input number in given range
     *
     * @param min left boundary of range
     * @param max right boundary of range
     */
    public void printPromptForInput(int min, int max) {
        printMessage(INPUT_NUMBER);
        printRangeMessage(min, max);
    }

    /**
     * By mean of {@link #stream} print detailed statistic of user game.
     *
     * @param history list, that contains users tries to guess the number
     * @param realNum number, that guess program
     */
    public void printHistory(List<Integer> history, int realNum) {
        printMessage(String.format(STEPS_CNT, history.size()));
        printMessage(String.format(GUESSED_VALUE, realNum));

        for(int i = 0; i < history.size(); i++) {
            printMessage(String.format(STEP_STATS, i + 1, history.get(i)));
        }
    }
}
