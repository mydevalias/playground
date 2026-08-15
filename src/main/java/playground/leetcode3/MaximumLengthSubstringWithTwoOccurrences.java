package playground.leetcode3;

public class MaximumLengthSubstringWithTwoOccurrences {

    public int maximumLengthSubstring(String s) {
        int chars[] = new int['z' - 'a' + 1];
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            chars[current]++;
            while (chars[current] > 2) {
                chars[s.charAt(left) - 'a']--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
