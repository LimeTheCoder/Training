package com.limethecoder.algorithms;


import com.limethecoder.algorithms.utility.ArraysUtil;

public class Main {
    public static void main(String[] args) {
        int[] first = new int[] {4, 9, 3, 6, 12};
        int[] second = new int[] {1, 9, 3, 13, 12, 7, 3};
        ArraysUtil.findDistinctElementsHash(first, second).forEach(System.out::println);
    }
}
