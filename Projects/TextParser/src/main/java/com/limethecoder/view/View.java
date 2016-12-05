package com.limethecoder.view;

import java.io.PrintStream;
import java.util.List;

/**
 * Part of MVC pattern that responsible for displaying information
 * for user
 *
 * @version 1.0 05 Dec 2016
 * @author Taras Sakharchuk
 */
public class View {

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
     * By mean of {@link #stream} print list of objects,
     * that passed as argument
     *
     * @param objects list of objects to display
     */
    public void printList(List objects) {
        for(Object obj : objects) {
            stream.println(obj);
        }
    }
}