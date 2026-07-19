package playground.leetcode2;

public class MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {
        int[] cl = countLetters(text);
        int min = Integer.MAX_VALUE;
        for (char c : "balloon".toCharArray()) {
            if (c == 'o' || c == 'l') {
                min = Math.min(min, cl[c-ST] / 2);
            } else {
                min = Math.min(min, cl[c-ST]);
            }
        }
        return min;
    }

    public static final int SZ = (int) 'z' - (int) 'a' + 1;
    public static final char ST = 'a';

    public static int[] countLetters(String text) {
        int[] counter = new int[SZ];
        for (int i = 0; i < text.length(); i++) {
            counter[text.charAt(i) - ST]++;
        }
        return counter;
    }
}
