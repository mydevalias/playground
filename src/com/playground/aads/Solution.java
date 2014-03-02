package com.playground.aads;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: liviu
 * Date: 2/23/14
 * Time: 2:01 PM
 */
public class Solution {

    public int solution(int[] A) {
        El[] tmp = new El[A.length];
        for (int i = 0; i < A.length; i++) {
            tmp[i] = new El(A[i], i);
        }

        Arrays.sort(tmp, new Comparator<El>() {
            @Override
            public int compare(El o1, El o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tmp.length - 1; i++) {
            int next = i + 1;
            while (next < tmp.length - 1 && tmp[i].value == tmp[next].value) {
                next++;
            }
            if (tmp[i].value != tmp[next].value) {
                int abs = Math.abs(tmp[i].pos - tmp[next].pos);
                if (abs < min) {
                    min = abs;
                }
                while (next < tmp.length - 1 && tmp[next].value == tmp[next + 1].value) {
                    next++;
                    abs = Math.abs(tmp[i].pos - tmp[next].pos);
                    if (abs < min) {
                        min = abs;
                    }
                }

            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    private static class El {
        int value;
        int pos;

        private El(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "El{" +
                    "value=" + value +
                    ", pos=" + pos +
                    '}';
        }
    }

    public static void main(String... aux) {
        //int A[] = new int[]{1, 2, 3, 1, 2};
        //int A[] = new int[]{1, 4, 7, 3, 3, 5};
        //int A[] = new int[]{5, 5, 5, 5, 5, 5};
        // int A[] = new int[]{5, 5, 5, 5, 5, 5, 7, 7, 7, 7, 7, 7, 7, 7, 7, 3};
        //int A[] = new int[]{5, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 3};
        //int A[] = new int[]{1, 2, 3, 4, 5};
        int A[] = new int[]{1, 3, 10, 7, 7, 9, 5, 8, 4, 2};
        System.out.println(new Solution().solution(A));
    }

}
