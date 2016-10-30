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

    /** Store number, that user will try to guess */
    private int value;

    /** Minimum of possible value */
    private int min;

    /** Maximum of possible value */
    private int max;

    /** Stores history of user guessing */
    private List<Integer> history;

    /**
     * Firstly check that params is correct and assing appropriate
     * values to {@code min} and {@code max} variables.
     * After intialize list for {@code history} and generate
     * number, that user should guess by calling {@link #generateValue()}
     *
     * @param min minimum possible value for generated number
     * @param max maximum possible value for generated number
     */
    public Model(int min, int max) {

        if(min <= max) {
            this.min = min;
            this.max = max;
        } else {
            this.min = max;
            this.max = min;
        }

        history = new ArrayList<>();

        generateValue();
    }

    /** Call {@link #Model(int, int)} constructor with arguments (1, 100) */
    public Model() {
        this(1, 100);
    }

    /** Generates number from uniform distribution, that user should guess */
    public void generateValue() {
        value = ThreadLocalRandom.current().nextInt(min, max + 1);
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
        history.add(num);

        if(value == num) {
            return true;
        }

        if(num > min && num < value) {
            min = num;
        }

        if(num < max && num > value) {
            max = num;
        }

        return false;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getHistory() {
        return history;
    }
}
