package playground.leetcode2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class RankTransformOfAnArray {

    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int a : arr) {
            set.add(a);
        }
        int[] sortedUnique = set.stream().mapToInt(Integer::intValue).toArray();
        HashMap<Integer, Integer> ranks = new HashMap<>();
        for (int i = 0; i < sortedUnique.length; i++) {
            ranks.put(sortedUnique[i], i+1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranks.get(arr[i]);
        }
        return arr;
    }

}
