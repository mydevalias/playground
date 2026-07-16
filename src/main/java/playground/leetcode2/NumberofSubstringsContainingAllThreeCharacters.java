package playground.leetcode2;

public class NumberofSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int total = 0;
        int left = 0;
        int[] c = {0, 0, 0};
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'a']++;
            while (isValid(c)) {
                total += s.length() - i;//at least one, so each string until the end
                c[s.charAt(left)-'a']--;
                left++;
            }
        }
        return total;
    }

    private boolean isValid(int[] c) {
        return c[0] > 0 && c[1] > 0 && c[2] > 0;
    }

}
