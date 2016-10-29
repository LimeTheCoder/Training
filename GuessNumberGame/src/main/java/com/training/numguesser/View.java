package com.training.numguesser;

import java.io.PrintStream;
import java.util.List;


public class View {
    public final static String INPUT_NUMBER = "Try to guess my number "
            + "(Press -1 to exit):";
    public final static String WRONG_INPUT = "Incorrect input data. Try again.";
    public final static String RANGE_HINT = "Guessed number is in range [%d - %d].";
    public final static String STEPS_CNT = "You performed %d steps";
    public final static String GUESSED_VALUE = "Guessed number: %d";
    public final static String STEP_STATS = "In step %d you entered %d";
    public final static String WIN_CASE = "Congratz! You win!";
    public final static String LOOSE_CASE = "Try next time";

    PrintStream stream;

    public View(PrintStream stream) {
        this.stream = stream;
    }

    public void printMessage(String message) {
        stream.println(message);
    }

    public void printRangeMessage(String msg, int min, int max) {
        printMessage(String.format(msg, min, max));
    }

    public void printHistory(List<Integer> history, int realNum) {
        printMessage(String.format(STEPS_CNT, history.size()));
        printMessage(String.format(GUESSED_VALUE, realNum));

        for(int i = 0; i < history.size(); i++) {
            printMessage(String.format(STEP_STATS, i + 1, history.get(i)));
        }
    }
}
