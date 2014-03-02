package com.playground.aads;

import java.util.List;

/**
 * User: liviu
 * Date: 3/2/14
 * Time: 3:27 PM
 */
public class BinarySearch {

    public static <V extends Comparable> int find(V value, List<V> list) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compareResult = value.compareTo(list.get(mid));
            if (compareResult == -1) {
                high = mid - 1;
            } else if (compareResult == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
