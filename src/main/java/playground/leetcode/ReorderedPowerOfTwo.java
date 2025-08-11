package playground.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOfTwo {

    public static Set<IntArrayWrapper> set = buildWrapper();

    public static int[] count(int number) {
        int[] digits = new int[10];
        if (number == 0) {
            digits[0] = 1;
            return digits;
        }
        while (number > 0) {
            int digit = number % 10;
            digits[digit]++;
            number /= 10;
        }
        return digits;
    }

    public boolean reorderedPowerOf2(int n) {
        return set.contains(new IntArrayWrapper(count(n)));
    }

    private static Set<IntArrayWrapper> buildWrapper() {
        Set<IntArrayWrapper> set = new HashSet<>();
        for (int power = 1; power > 0; power <<= 1) {
            set.add(new IntArrayWrapper(count(power)));
        }
        return set;
    }

    static class IntArrayWrapper {
        private final int[] array;

        public IntArrayWrapper(int[] array) {
            this.array = array;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IntArrayWrapper that = (IntArrayWrapper) o;
            return Arrays.equals(array, that.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }
    }

    public static void main(String[] args) {
        ReorderedPowerOfTwo x = new ReorderedPowerOfTwo();
        System.out.println(x.reorderedPowerOf2(2));
    }

}
