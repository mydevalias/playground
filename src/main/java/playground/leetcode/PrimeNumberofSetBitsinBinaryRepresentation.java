package playground.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumberofSetBitsinBinaryRepresentation {

    Set<Integer> PRIMES = new HashSet<>(Arrays.asList(
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
            31, 37, 41, 43, 47, 53, 59, 61
    ));

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (PRIMES.contains(Integer.bitCount(i))) {
                res++;
            }
        }
        return res;
    }

}
