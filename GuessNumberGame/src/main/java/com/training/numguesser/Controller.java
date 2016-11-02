package com.training.numguesser;

import java.io.InputStream;
import java.util.Scanner;


/**
 * Part of MVC pattern that accepts input and converts it
 * to commands for the Model or View.
 *
 * @version 1.0 29 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see Model
 * @see View
 */
public class Controller {
    /* Controller knows about model and view */
    private Model model;
    private View view;

    /** By mean of scanner controller will get input information from user */
    private Scanner scanner;

    /**
     * Controller that initialize {@link #model} and {@link #view}
     * by arguments that passed.
     * Call {@link #setScanner(InputStream)} method
     * with {@code System.in} argument to intialize the scanner.
     *
     * @param model
     * @param view
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        setScanner(System.in);
    }

    public void setScanner(InputStream stream) {
        scanner = new Scanner(stream);
    }

    /**
     * Delegate view to display appropriate messages for user and
     * process user input to get integer value.
     *
     * @return integer number that user input
     */
    private int handleInput() {
        int res;

        while(true) {
            view.printPromptForInput(model.getMin(), model.getMax());

            res = readInteger();

            if(model.checkRange(res)) { break; }

            view.printMessage(View.NOT_IN_RANGE);
            view.printMessage(View.NEW_LINE);
        }

        return res;
    }

    /**
     * Get integer value from user
     *
     * @return integer users input
     */
    private int readInteger() {
        while (!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT);
            view.printMessage(View.NEW_LINE);
            view.printMessage(View.INPUT_INT);

            scanner.next();
        }

        return scanner.nextInt();
    }

    /**
     * Get from user left and right boundaries of secret value and
     * perform validation of boundaries.
     * In case of invalid boundaries use default values.
     */
    private void handleBoundaries() {
        int left;
        int right;

        view.printMessage(View.WELCOME_MSG);

        view.printMessage(View.INPUT_LEFT_BOUNDARY);
        left = readInteger();

        view.printMessage(View.INPUT_RIGHT_BOUNDARY);
        right = readInteger();

        /*
         * Check is valid boundaries.
         * In case of invalid boundaries use default values.
         */

        try {
            model.setBoundaries(left, right);
        }
        catch (IllegalArgumentException e) {
            view.printMessage(View.INVALID_RANGE);
            model.setBoundaries(Constants.DEFAULT_MIN_BOUNDARY,
                    Constants.DEFAULT_MAX_BOUNDARY);
        }
        finally {
            model.generateValue();
        }
    }

    /**
     * Get user input from {@link #handleInput()} method and
     * interact with {@link Model} to check is user guess is correct.
     * If user guessed number or decided to leave game, method delegate
     * to {@link View} to print appropriate message.
     */
    public void run() {
        int n;

        handleBoundaries();

        /* Handle user prediction and check is secret number is guessed */
        do {
            n = handleInput();
        } while(n != -1 && !model.checkGuess(n));

        view.printMessage((n == -1) ? View.LOOSE_CASE : View.WIN_CASE);
        view.printHistory(model.getHistory(), model.getSecretValue());
    }
}
