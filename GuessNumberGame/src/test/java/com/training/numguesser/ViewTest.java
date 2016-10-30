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
        int min = 1;
        int max = 23;
        view.printRangeMessage(min, max);
        assertEquals(out.toString(),
                String.format(View.RANGE_HINT, min, max) + "\n");
    }
}
