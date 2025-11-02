package playground.leetcode;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/
 */
public class MaximumFrequencyElementAfterPerformingOperationsI {

    public int maxFrequency2(int[] nums, int k, int numOperations) {
        Map<Integer, int[]> counts = new HashMap<>();

        for (int num : nums) {
            for (int target = num - k; target <= num + k; target++) {
                counts.putIfAbsent(target, new int[2]);
                if (target == num) {
                    counts.get(target)[0]++;
                } else {
                    counts.get(target)[1]++;
                }
            }
        }

        int max = 0;
        for (int[] count : counts.values()) {
            int exact = count[0];
            int needsOp = count[1];
            max = Math.max(max, exact + Math.min(numOperations, needsOp));
        }

        return max;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        HashMap<Integer, Content> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i] - k; j < nums[j] + k; j++) {
                countNonOps(counts, j, nums[i]);
            }
        }
        int max = 0;
        for (Content el : counts.values()) {
            var o = Math.min(numOperations, el.ops);

            max = Math.max(max, el.nonOps + o);
        }
        return max;
    }

    public int maxFrequency3(int[] nums, int k, int numOperations) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int c = entry.getKey();
            var extra = 0;
            for (int i = 1; i <= k; i++) {
                var ce = 0;
                Integer i1 = counts.get(c + i);
                if (i1 != null) {
                    ce = i1;
                }
                Integer i2 = counts.get(c - i);
                if (i2 != null) {
                    ce = ce + i2;
                }
                extra += ce;
                if (extra > numOperations) {
                    extra = numOperations;
                    break;
                }
            }
            max = Math.max(max, entry.getValue() + extra);
        }
        return max;
    }

    private void countNonOps(HashMap<Integer, Content> counts, int k, int current) {
        Content ct = counts.get(k);
        if (ct == null) {
            ct = new Content();
            counts.put(k, ct);
        }
        if (k == current) {
            ct.nonOps++;
        } else {
            ct.ops++;
        }
    }

    class Content {
        int ops = 0;
        int nonOps = 0;
    }

}
