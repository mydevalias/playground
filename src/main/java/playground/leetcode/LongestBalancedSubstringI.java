package playground.leetcode;

import java.util.Arrays;

public class LongestBalancedSubstringI {

    public int longestBalanced(String s) {
        int longest = 0;
        int counter[] = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i < longest) {
                break;
            }
            Arrays.fill(counter, 0);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                counter[c - 'a']++;
                int balanced = isBalanced(counter);
                if (balanced != -1) {
                    longest = Math.max(longest, balanced);
                }
            }
        }

        return longest;
    }

    private int isBalanced(int[] counter) {
        int size = 0;
        int expect = -1;
        for (int i = 0; i < counter.length; i++) {

            if (counter[i] == 0) {
                continue;
            }
            if (expect == -1) {
                expect = counter[i];
                size++;
                continue;
            }
            if (counter[i] != expect) {
                return -1;
            }
            size++;
        }
        return size * expect;
    }

}
