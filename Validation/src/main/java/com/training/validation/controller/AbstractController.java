package com.training.validation.controller;

import com.training.validation.controller.validator.Validator;
import com.training.validation.controller.validator.ValidatorFactory;
import com.training.validation.view.View;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Part of MVC pattern that accepts input and converts it
 * to commands for the Model or View.
 *
 * @version 1.0 07 Nov 2016
 * @author Taras Sakharchuk
 */
public abstract class AbstractController <T> {

    /** Object, that will be managed by controller */
    protected T entity;

    /** Provides ability to display information for user */
    protected View view;

    /** Provides different kind of validators */
    protected ValidatorFactory factory;

    /** By mean of scanner controller will get input information from user */
    protected Scanner scanner;

    /**
     * Constructor that initialize {@link #view}, {@link #factory}.
     * Also constructor calls {@link #setScanner(InputStream)} method
     * with {@code System.in} argument to intialize the scanner.
     *
     * @param view view, that provides ability to display information for user
     * @param factory factory, that provides different kind of validators
     */
    public AbstractController(View view, ValidatorFactory factory) {
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
    protected String getInput(String msg, Validator validator) {
        view.printMessage(msg);
        String input = scanner.nextLine();
        while(!validator.isValid(input)) {
            view.printError(validator.getError());
            view.printMessage(msg);
            input = scanner.nextLine();
        }
        return input;
    }

    public T getEntity() {
        return entity;
    }

    /**
     * Fill up all fields of entity with valid information
     * provided by user.
     *
     * @return filled entity
     */
    public abstract T processEntity();
}
