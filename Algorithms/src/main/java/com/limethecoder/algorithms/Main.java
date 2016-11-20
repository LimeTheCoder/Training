package com.limethecoder.algorithms;


import com.limethecoder.algorithms.utility.ArraysUtil;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 5, 2, 8, 5, 6, 8, 8};

        Arrays.stream(ArraysUtil.sortByFrequency(arr)).forEach(System.out::println);
    }
}
