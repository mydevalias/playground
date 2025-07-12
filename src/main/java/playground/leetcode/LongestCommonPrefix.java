package playground.leetcode;

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String longest = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longest = of(longest, strs[i]);
        }
        return longest;
    }

    private String of(String longest, String str) {
        for (int i = 0; i < Math.min(longest.length(), str.length()); i++) {
            if (longest.charAt(i) != str.charAt(i)) {
                return longest.substring(0, i);
            }
        }
        if (longest.length() < str.length()) {
            return longest;
        }
        return str;
    }

}
