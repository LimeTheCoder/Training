package com.training.validation.controller;

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

    /** By mean of scanner controller will get input information from user */
    private Scanner scanner;

    /**
     * Controller that initialize {@link #view}.
     * Call {@link #setScanner(InputStream)} method
     * with {@code System.in} argument to intialize the scanner.
     *
     * @param view
     */
    public Controller(View view) {
        this.view = view;

        setScanner(System.in);
    }

    public void setScanner(InputStream stream) {
        scanner = new Scanner(stream);
    }

}
