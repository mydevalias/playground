package playground.leetcode;

public class MinimumNumberIncrementsSubarraysFormTargetArray {

    public int minNumberOperationsSearch(int[] target, int from, int to) {
        if (from >= to) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int i = from; i < to; i++) {
            if (target[i] < min) {
                min = target[i];
            }
        }

        int ret = min;

        int start = from;
        for (int i = from; i <= to; i++) {
            if (i < to) {
                target[i] -= min;
            }
            if (i == to || target[i] == 0) {
                if (i > start) {
                    ret += minNumberOperationsSearch(target, start, i);
                }
                start = i + 1;
            }
        }

        return ret;
    }

    public int minNumberOperationsSlow(int[] target) {
        return minNumberOperationsSearch(target.clone(), 0, target.length);
    }

    private int minNumberOperations(int[] target) {
        int ret = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                ret += target[i] - target[i - 1];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MinimumNumberIncrementsSubarraysFormTargetArray m = new MinimumNumberIncrementsSubarraysFormTargetArray();
//        System.out.println(m.minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        System.out.println(m.minNumberOperations(new int[]{3, 1, 1, 2}));
    }


}
