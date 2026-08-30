package playground.leetcode3;


import java.util.*;

public class MakeLexicographicallySmallestArraybySwappingElements {


    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> valToGroup = new HashMap<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();

        int groupid = 0;
        groups.computeIfAbsent(groupid, k -> new LinkedList<>()).add(sorted[0]);
        valToGroup.put(sorted[0], groupid);
        for (int i = 1; i < sorted.length; i++) {
            if (Math.abs(sorted[i] - sorted[i - 1]) > limit) {
                groupid++;
            }
            groups.computeIfAbsent(groupid, k -> new LinkedList<>()).add(sorted[i]);
            valToGroup.put(sorted[i], groupid);
        }

        //rebuild
        for (int i = 0; i < nums.length; i++) {
            int groupId = valToGroup.get(nums[i]);
            nums[i] = groups.get(groupId).removeFirst();
        }

        return nums;

    }
}
