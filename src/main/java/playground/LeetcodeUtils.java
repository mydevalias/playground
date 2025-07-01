package playground;

/**
 * I keep needing some methods while practicing on LeetCode.
 */
public class LeetcodeUtils {

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
