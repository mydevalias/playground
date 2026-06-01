package playground.leetcode2;

public class CountTheNumberOfSpecialCharactersII {

    public int numberOfSpecialChars(String word) {
        int[] count = countLetters(word);
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (count[Character.toLowerCase(c) - ST] < 0) {
                continue;
            }
            if (Character.isUpperCase(c)) {
                count[Character.toLowerCase(c) - ST] = -1;
            } else {
                count[c - ST]--;
                if (count[c - ST] == 0 &&   count[Character.toUpperCase(c) - ST]>0) {
                    res++;
                }
            }
        }
        return res;
    }

    public static final int SZ = (int) 'z' - (int) 'A' + 1;
    public static final char ST = 'A';

    public static int[] countLetters(String s2) {
        int[] counter = new int[SZ];
        for (int i = 0; i < s2.length(); i++) {
            counter[s2.charAt(i) - ST]++;
        }
        return counter;
    }


}
