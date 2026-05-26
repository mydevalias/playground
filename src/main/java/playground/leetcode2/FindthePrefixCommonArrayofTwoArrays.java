package playground.leetcode2;

import java.util.HashSet;
import java.util.Set;

public class FindthePrefixCommonArrayofTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        int res[] =new int[A.length];
        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
            Set<Integer> intersection = new HashSet<>(a);
            intersection.retainAll(b);
            res[i] = intersection.size();
        }
        return res;
    }
}
