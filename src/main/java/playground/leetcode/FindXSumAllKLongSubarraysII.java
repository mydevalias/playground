package playground.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FindXSumAllKLongSubarraysII {

    public long[] findXSum(int[] nums, int k, int x) {
        long[] res = new long[nums.length - k + 1];
        FrequencyTracker tracker = new FrequencyTracker();

        for (int i = 0; i < k; i++) {
            tracker.add(nums[i]);
        }
        res[0] = tracker.sumX(x);

        for (int i = 1; i < res.length; i++) {
            tracker.remove(nums[i - 1]);
            tracker.add(nums[i + k - 1]);
            res[i] = tracker.sumX(x);
        }

        return res;
    }

    class FrequencyTracker {
        private Map<Integer, Integer> freq;
        private TreeSet<int[]> sorted;

        public FrequencyTracker() {
            this.freq = new HashMap<>();
            this.sorted = new TreeSet<>((a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            });
        }

        public void add(int value) {
            if (freq.containsKey(value)) {
                sorted.remove(new int[]{value, freq.get(value)});
            }
            freq.put(value, freq.getOrDefault(value, 0) + 1);
            sorted.add(new int[]{value, freq.get(value)});
        }

        public void remove(int value) {
            sorted.remove(new int[]{value, freq.get(value)});
            freq.put(value, freq.get(value) - 1);
            if (freq.get(value) == 0) {
                freq.remove(value);
            } else {
                sorted.add(new int[]{value, freq.get(value)});
            }
        }

        public long sumX(int x) {
            long sum = 0;
            int count = 0;
            for (int[] pair : sorted) {
                if (count >= x) break;
                sum += (long) pair[0] * pair[1];
                count++;
            }
            return sum;
        }
    }
}
