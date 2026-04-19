package playground.leetcode2;

import java.util.*;

public class ClosestEqualElementQueries {

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int n = nums.length;
        List<Integer> results = new ArrayList<>();

        for (int q : queries) {
            int val = nums[q];
            List<Integer> allPos = positions.get(val);

            if (allPos.size() == 1) {
                results.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(allPos, q);

            int next;
            if (idx == allPos.size() - 1) {
                next = allPos.get(0);
            } else {
                next = allPos.get(idx + 1);
            }

            int prev;
            if (idx == 0) {
                prev = allPos.get(allPos.size() - 1);
            } else {
                prev = allPos.get(idx - 1);
            }

            int distNext;
            if (next > q) {
                distNext = next - q;
            } else {
                distNext = n - q + next;
            }

            int distPrev;
            if (prev < q) {
                distPrev = q - prev;
            } else {
                distPrev = n - prev + q;
            }

            results.add(Math.min(distNext, distPrev));
        }

        return results;
    }

}
