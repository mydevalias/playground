package playground.leetcode;

public class MaximumNumberWordsYouCanType {

    public static final int SZ = 'z' - 'a' + 1;

    public static int[] countLetters(String s2) {
        int[] counter = new int[SZ];
        for (int i = 0; i < s2.length(); i++) {
            counter[s2.charAt(i) - 'a']++;
        }
        return counter;
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        int[] lt = countLetters(brokenLetters);
        int res = 0;
        boolean current = true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (current) {
                    res++;
                }
                current = true;
            } else {
                if (lt[c - 'a'] > 0) {
                    current = false;

                }
            }
        }
        if (current) {
            res++;
        }
        return res;
    }

}
