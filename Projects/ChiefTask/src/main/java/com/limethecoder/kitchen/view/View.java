package com.limethecoder.kitchen.view;

import java.io.PrintStream;
import java.util.List;

/**
 * Part of MVC pattern that responsible for displaying information
 * for user
 *
 * @version 1.0 18 Nov 2016
 * @author Taras Sakharchuk
 */
public class View {

    public final static String INGREDIENTS = "Ingredients:";
    public final static String TOTAL_CALORIES = "Total calories:";
    public final static String SORTED_INGREDIENTS =
            "Sorted ingredients:";
    public final static String FILTERED_BY_RANGE =
            "Filtered by calories range [%d - %d]";

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

    /**
     * By mean of {@link #stream} print {@link #FILTERED_BY_RANGE} message
     * with given {@code max} and {@code min} parameters
     *
     * @param min left boundary of range
     * @param max right boundary of range
     */
    public void printRangeMessage(int min, int max) {
        printMessage(String.format(FILTERED_BY_RANGE, min, max));
    }
}
