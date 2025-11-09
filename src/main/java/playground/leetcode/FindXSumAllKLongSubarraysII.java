package playground.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FindXSumAllKLongSubarraysII {

    public long[] findXSum(int[] nums, int k, int x) {
        long[] res = new long[nums.length - k + 1];
        FrequencyTracker tracker = new FrequencyTracker(x);

        for (int i = 0; i < k; i++) {
            tracker.add(nums[i]);
        }
        res[0] = tracker.getSum();

        for (int i = 1; i < res.length; i++) {
            tracker.remove(nums[i - 1]);
            tracker.add(nums[i + k - 1]);
            res[i] = tracker.getSum();
        }

        return res;
    }

    class FrequencyTracker {
        private Map<Integer, Integer> freq;
        private TreeSet<int[]> topX;
        private TreeSet<int[]> rest;
        private int x;
        private long cachedSum;
        private Comparator<int[]> comp;

        public FrequencyTracker(int x) {
            this.freq = new HashMap<>();
            this.x = x;
            this.cachedSum = 0;
            this.comp =getComparator();

            this.topX = new TreeSet<>(comp);
            this.rest = new TreeSet<>(comp);
        }

        private static Comparator<int[]> getComparator() {
            return (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                return b[0] - a[0];
            };
        }

        public void add(int value) {
            if (freq.containsKey(value)) {
                int[] oldPair = new int[]{value, freq.get(value)};
                removeFromSets(oldPair);
            }

            freq.put(value, freq.getOrDefault(value, 0) + 1);
            int[] newPair = new int[]{value, freq.get(value)};
            addToSets(newPair);
        }

        public void remove(int value) {
            int[] oldPair = new int[]{value, freq.get(value)};
            removeFromSets(oldPair);

            freq.put(value, freq.get(value) - 1);
            if (freq.get(value) == 0) {
                freq.remove(value);
            } else {
                int[] newPair = new int[]{value, freq.get(value)};
                addToSets(newPair);
            }
        }

        public long getSum() {
            return cachedSum;
        }

        private void removeFromSets(int[] pair) {
            if (topX.remove(pair)) {
                cachedSum -= (long) pair[0] * pair[1];
                if (!rest.isEmpty()) {
                    int[] promote = rest.pollFirst();
                    topX.add(promote);
                    cachedSum += (long) promote[0] * promote[1];
                }
            } else {
                rest.remove(pair);
            }
        }

        private void addToSets(int[] pair) {
            if (topX.size() < x) {
                topX.add(pair);
                cachedSum += (long) pair[0] * pair[1];
            } else {
                int[] last = topX.last();

                if (this.comp.compare(pair, last) < 0) {
                    topX.remove(last);
                    cachedSum -= (long) last[0] * last[1];
                    topX.add(pair);
                    cachedSum += (long) pair[0] * pair[1];
                    rest.add(last);
                } else {
                    rest.add(pair);
                }
            }
        }
    }
}
