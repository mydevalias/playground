package playground.leetcode;

import java.util.*;

public class SortIntegersByTheNumberOf1Bits {

    public int[] sortByBits(int[] arr) {
        Comparator<Integer> comp = Comparator.comparingInt(Integer::bitCount).thenComparingInt(a -> a);
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            list.add(val);
        }
        list.sort(comp);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
