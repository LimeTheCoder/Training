package com.limethecoder.algorithms;


import com.limethecoder.algorithms.utility.ArraysUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //int[] first = new int[] {4, 9, 3, 6, 12};
        //int[] second = new int[] {1, 9, 3, 13, 12, 7, 3};
        int[] arr = new int[] {2, 5, 2, 8, 5, 6, 8, 8};

        Arrays.stream(ArraysUtil.sortByFrequency(arr)).forEach(System.out::println);
        //ArraysUtil.findDistinctElementsHash(first, second).forEach(System.out::println);
    }
}
