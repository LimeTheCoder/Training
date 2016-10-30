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
        view.printMessage(View.INPUT_NUMBER);
        view.printRangeMessage(model.getMin(), model.getMax());

        while(!scanner.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT);
            view.printMessage(View.INPUT_NUMBER);
            scanner.next();
        }

        return scanner.nextInt();
    }

    /**
     * Get user input from {@link #handleInput()} method and
     * interact with {@link Model} to check is user guess is correct.
     * If user guessed number or decided to leave game, method delegate
     * to {@link View} to print appropriate message.
     */
    public void run() {
        int n = handleInput();

        while(n != -1 && !model.checkGuess(n)) {
            n = handleInput();
        }

        view.printMessage((n == -1) ? View.LOOSE_CASE : View.WIN_CASE);
        view.printHistory(model.getHistory(), model.getValue());
    }
}
