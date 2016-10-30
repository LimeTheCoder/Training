package com.training.numguesser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ModelTest {
    private int max = 100;
    private int min = 0;
    private Model model;

    @Before
    public void init() {
        model = new Model(min, max);
    }

    @Test
    public void testCheckGuess() {
        assertFalse(model.checkGuess(max + 1));
        assertTrue(model.checkGuess(model.getValue()));
    }

    @Test
    public void testRange() {
        assertTrue(model.getValue() <= max && model.getValue() >= min);
    }

    @Test
    public void testHistory() {
        assertTrue(model.getHistory().isEmpty());

        model.checkGuess(model.getMin() + 1);
        model.checkGuess(model.getMax() - 1);

        assertTrue(model.getHistory().size() == 2);
    }

    @Test
    public void testReverseRangeAssignment() {
        Model m = new Model(max, min);

        assertTrue(m.getMax() == max);
        assertTrue(m.getMin() == min);
    }
}
