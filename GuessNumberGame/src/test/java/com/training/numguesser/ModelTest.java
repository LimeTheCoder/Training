package com.training.numguesser;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ModelTest {
    private Model model;

    @Before
    public void init() {
        model = new Model(Constants.DEFAULT_MIN_BOUNDARY,
                Constants.DEFAULT_MAX_BOUNDARY);
    }

    @Test
    public void testCheckGuess() {
        assertFalse(model.checkGuess(Constants.DEFAULT_MAX_BOUNDARY));
        assertTrue(model.checkGuess(model.getSecretValue()));
    }

    @Test
    public void testRange() {
        for(int i = 0; i < 1000; i++) {
            model.generateValue();
            assertTrue(model.getMin() < model.getSecretValue());
            assertTrue(model.getMax() > model.getSecretValue());
        }
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
        Model m = new Model(Constants.DEFAULT_MAX_BOUNDARY,
                Constants.DEFAULT_MIN_BOUNDARY);

        assertTrue(m.getMax() == Constants.DEFAULT_MAX_BOUNDARY);
        assertTrue(m.getMin() == Constants.DEFAULT_MIN_BOUNDARY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidRangeArguments() {
        new Model(Constants.DEFAULT_MIN_BOUNDARY,
                Constants.DEFAULT_MIN_BOUNDARY);
    }
}
