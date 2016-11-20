package com.limethecoder.algorithms.utility;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Utility class that stores implementation of algorithms for arrays
 *
 * @version 1.0 20 Nov 2016
 * @author Taras Sakharchuk
 */
public class ArraysUtil {
    /**
     * Finds elements, that doesn't have equivalent in opposite array
     * Algorithm complexity: O(n log(n))
     *
     * <p>Examples</p>
     * Input: first[] = {4, 9, 3, 6, 12}, second[] = {1, 9, 3, 13, 12, 7, 3}
     * Output: result[] = {1, 3, 4, 6, 7, 13}
     *
     * @param first first array
     * @param second second array
     * @return list of elements, that doesn't have equivalent in opposite array
     * @throws NullPointerException if one of arguments is null
     */
    public static List<Integer> findDistinctElements(int [] first, int[] second) {
        Objects.requireNonNull(first, "First array must not be null");
        Objects.requireNonNull(second, "Second array must not be null");

        Arrays.sort(first);
        Arrays.sort(second);

        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                while (i < first.length && first[i] < second[j]) {
                    result.add(first[i]);
                    i++;
                }
            } else if(second[j] < first[i]) {
                while (j < second.length && second[j] < first[i]) {
                    result.add(second[j]);
                    j++;
                }
            } else {
                while(i < first.length && j < second.length && first[i] == second[j]) {
                    i++;
                    j++;
                }
            }
        }

        /* In case, when first array is larger than second */
        while (i < first.length) {
            result.add(first[i]);
            i++;
        }

        /* In case, when second array is larger than first */
        while (j < second.length) {
            result.add(second[j]);
            j++;
        }

        return result;
    }


    /**
     * Finds elements, that doesn't have equivalent in opposite array.
     * Used map to implement that version of algorithm.
     *
     * <p>Examples</p>
     * Input: first[] = {4, 9, 3, 6, 12}, second[] = {1, 9, 3, 13, 12, 7, 3}
     * Output: result[] = {1, 3, 4, 6, 7, 13}
     *
     * Faster than {@link #findDistinctElements(int[], int[])} version
     * of that algorithm with sorting, but require more additional space.
     *
     * Algorithm complexity: O(n)
     * Space complexity : O(n)
     *
     * @param first first array
     * @param second second array
     * @return list of elements, that doesn't have equivalent in opposite array
     * @throws NullPointerException if one of arguments is null
     */
    public static List<Integer> findDistinctElementsHash(int [] first, int[] second) {
        Objects.requireNonNull(first, "First array must not be null");
        Objects.requireNonNull(second, "Second array must not be null");

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int element : first) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for(int element : second) {
            map.put(element, map.getOrDefault(element, 0) - 1);
        }

        for(Integer key : map.keySet()) {
            int k = Math.abs(map.get(key));
            for(int j = k; j > 0; j--) {
                result.add(key);
            }
        }

        return result;
    }



    /**
     * Sort array based on element frequency.
     *
     * <p>Examples</p>
     * Input: arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
     * Output: result[] = {8, 8, 8, 2, 2, 5, 5, 6}
     *
     * Algorithm complexity: O(n log(n)), because we need to sort map entries
     * and in worst case each entry will store
     * exactly one element of original array
     *
     * Space complexity : O(n), use additional map and list structures
     *
     * @param arr array for sorting
     * @return array sorted based on element frequency
     * @throws NullPointerException if passed as argument array is null
     */
    public static int[] sortByFrequency(int[] arr) {
        Objects.requireNonNull(arr, "Array must not be null");

        Map<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer, Integer>> sortedEntries;

        int[] result = new int[arr.length];

        for(int element : arr) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        sortedEntries = map.entrySet().stream().
                sorted(Map.Entry.comparingByValue((a, b) -> b - a))
                .collect(Collectors.toList());

        int arrIdx = 0;

        for(Map.Entry<Integer, Integer> entry : sortedEntries) {
            for(int i = 0; i < entry.getValue(); i++) {
                result[arrIdx] = entry.getKey();
                arrIdx++;
            }
        }

        return result;
    }
}
