package com.training.numguesser;


import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ViewTest {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    View view = new View(new PrintStream(out));

    @Test
    public void testPrintMessage() {
        view.printMessage(View.INPUT_NUMBER);
        assertEquals(out.toString(), View.INPUT_NUMBER + "\n");
    }

    @Test
    public void testPrintRangeMessage() {
        view.printRangeMessage(Constants.DEFAULT_MIN_BOUNDARY,
                Constants.DEFAULT_MAX_BOUNDARY);

        assertEquals(
                out.toString(),
                String.format(View.RANGE_HINT, Constants.DEFAULT_MIN_BOUNDARY,
                        Constants.DEFAULT_MAX_BOUNDARY) + "\n"
        );
    }
}
