package com.training.numguesser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Part of MVC pattern that store data and provides business logic
 * to operate on that data.
 * Also model knows nothing about other components like View and Controller
 *
 * @version 1.0 29 Oct 2016
 * @author Taras Sakharchuk
 *
 * @see View
 * @see Controller
 */
public class Model {

    /**
     * Store number, that user will try to guess.
     * Secret value always in range
     * between exclusive {@link #min} and {@link #max}.
     */
    private int secretValue;

    /**
     * Left boundary of secret game value.
     * Game secret value always greater than that number.
     */
    private int min;

    /**
     * Right boundary of secret game value.
     * Game secret value always smaller than that number
     */
    private int max;

    /** Stores history of user guessing */
    private List<Integer> history;

    /**
     * Firstly check that params is correct and assing appropriate
     * values to {@code min} and {@code max} variables.
     * After initialize list for {@code history} and generate
     * number, that user should guess by calling {@link #generateValue()}
     *
     * @param min left boundary of secret game value
     * @param max right boundary of secret game value
     */
    public Model(int min, int max) {
        setBoundaries(min, max);
        history = new ArrayList<>();
        generateValue();
    }

    /** Call {@link #Model(int, int)} constructor with default arguments */
    public Model() {
        this(Constants.DEFAULT_MIN_BOUNDARY, Constants.DEFAULT_MAX_BOUNDARY);
    }

    /** Generates number from uniform distribution
     * in range (min, max) exclusive, that user should guess */
    public void generateValue() {
        secretValue = ThreadLocalRandom.current().nextInt(min + 1, max);
    }

    /**
     * Check is user prediction is correct and update
     * {@link #min} and {@link #max} range boundaries.
     * Also add user guess to {@link #history} of tries.
     *
     * @param num user prediction
     * @return {@code true} if user make right guess and
     *         {@code false} if user prediction is not correct.
     */
    public boolean checkGuess(int num) {

        saveToHistory(num);

        if(!checkRange(num)) {
            return false;
        }

        if(secretValue == num) {
            return true;
        }

        if(num < secretValue) {
            min = num;
        } else {
            max = num;
        }

        return false;
    }

    /**
     * Check is argument in range between {@link #min} and {@link #max}
     *
     * @param num number for checking
     * @return {@code true} if number in range between min and max exclusively
     *         {@code false} if number is out of range (min, max)
     */
    public boolean checkRange(int num) {
        return num > min && num < max;
    }

    /**
     * Set min and max boundaries for secret game value.
     *
     * @param min left boundary of secret game value
     * @param max right boundary of secret game value
     * @throws IllegalArgumentException In case, when arguments are invalid
     */
    public void setBoundaries(int min, int max) {
        if(min < max) {
            this.min = min;
            this.max = max;
        } else {
            this.min = max;
            this.max = min;
        }

        /* Cause secret value always lay between min and max exclusively,
         * so equation min < secretValue < max must be correct,
         * as a result (max - min) must be always greater or equal than 2
         */
        if(this.max - this.min < 2) {
            throw new IllegalArgumentException("Invalid boundaries");
        }
    }

    /**
     * Add argument to history.
     *
     * @param num number, that should be stored to history
     */
    private void saveToHistory(int num) { history.add(num); }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public void setSecretValue(int secretValue) {
        this.secretValue = secretValue;
    }

    public List<Integer> getHistory() {
        return history;
    }
}
