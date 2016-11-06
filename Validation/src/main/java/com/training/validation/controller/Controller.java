package com.training.validation.controller;

import com.training.validation.controller.validator.Validator;
import com.training.validation.controller.validator.ValidatorFactory;
import com.training.validation.model.Record;
import com.training.validation.view.View;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Part of MVC pattern that accepts input and converts it
 * to commands for the Model or View.
 *
 * @version 1.0 06 Nov 2016
 * @author Taras Sakharchuk
 */
public class Controller {
    /* Controller knows about model and view */
    private Record record;
    private View view;
    ValidatorFactory factory;

    /** By mean of scanner controller will get input information from user */
    private Scanner scanner;

    /**
     * Controller that initialize {@link #view}.
     * Call {@link #setScanner(InputStream)} method
     * with {@code System.in} argument to intialize the scanner.
     *
     * @param view
     */
    public Controller(View view, ValidatorFactory factory) {
        this.view = view;
        this.factory = factory;

        setScanner(System.in);
    }

    public void setScanner(InputStream stream) {
        scanner = new Scanner(stream);
    }

    /**
     * Get valid input from user
     *
     * @param msg promt message for user
     * @param validator object, that will check is input is valid
     * @return user's input
     */
    public String getInput(String msg, Validator validator) {
        view.printMessage(msg);
        String input = scanner.nextLine();
        while(!validator.isValid(input)) {
            view.printMessage(validator.getError());
            view.printMessage(msg);
            input = scanner.nextLine();
        }
        return input;
    }

    public void run() {
        view.printMessage(getInput(View.PROMT_EMAIL,
                factory.getValidator(ValidatorFactory.EMAIL_VALIDATOR)));
    }
}
