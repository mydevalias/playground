package playground.leetcode3;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubsequencesII {

    String s;
    Set<String> seen;

    public int distinctSubseqII(String s) {
        this.s = s;
        this.seen = new HashSet<>();
        bk(0, new StringBuilder());
        return seen.size() % 1_000_000_007;
    }

    private void bk(int index, StringBuilder current) {
        if (index == s.length()) {
            if (!current.isEmpty()) {
                seen.add(current.toString());
            }
            return;
        }

        // skip this character
        bk(index + 1, current);

        // include this character
        current.append(s.charAt(index));
        bk(index + 1, current);
        current.deleteCharAt(current.length() - 1);
    }
}
