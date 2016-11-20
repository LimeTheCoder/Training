package com.limethecoder.algorithms;

import com.limethecoder.algorithms.utility.ArraysUtil;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class AlgorithmsTest {
    @Test
    public void testSortByFrequency() {
        int[] arr = new int[] {2, 5, 2, 8, 5, 6, 8, 8};
        int[] sorted = ArraysUtil.sortByFrequency(arr);

        assertArrayEquals(sorted, new int[] {8, 8, 8, 2, 2, 5, 5, 6});
    }

    @Test(expected = NullPointerException.class)
    public void testSortByFrequencyNullArgument() {
        ArraysUtil.sortByFrequency(null);
    }

    @Test
    public void testFindDistinctElements() {
        int[] first = new int[] {4, 9, 3, 6, 12};
        int[] second = new int[] {1, 9, 3, 13, 12, 7, 3};

        assertEquals(ArraysUtil.findDistinctElements(first, second),
                Arrays.asList(1, 3, 4, 6, 7, 13));
    }

    @Test(expected = NullPointerException.class)
    public void testFindDistinctElementsNullArguments() {
        ArraysUtil.findDistinctElements(null, null);
    }

    @Test
    public void testFindDistinctElementsHash() {
        int[] first = new int[] {4, 9, 3, 6, 12};
        int[] second = new int[] {1, 9, 3, 13, 12, 7, 3};

        assertEquals(ArraysUtil.findDistinctElementsHash(first, second),
                Arrays.asList(1, 3, 4, 6, 7, 13));
    }

    @Test(expected = NullPointerException.class)
    public void testFindDistinctElementsHashNullArguments() {
        ArraysUtil.findDistinctElementsHash(null, null);
    }
}
