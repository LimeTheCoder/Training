package com.training.numguesser;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Model {
    private int value;
    private int min;
    private int max;

    private List<Integer> history;

    public Model(int min, int max) {
        this.min = min;
        this.max = max;

        history = new ArrayList<>();

        generateValue();
    }

    public Model() {
        this(1, 100);
    }

    public void generateValue() {
        value = ThreadLocalRandom.current().nextInt(min, max + 1);
    }

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
