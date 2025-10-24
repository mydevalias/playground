package playground.leetcode;

public class CheckDigitsAreEqualStringAfterOperationsI {

    public boolean hasSameDigits(String s) {
        int chars[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i) - '0';
        }

        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = 0; j < s.length() - i-1; j++) {
                chars[j] = (chars[j] + chars[j + 1]) % 10;
            }
        }

        return chars[0] == chars[1];
    }

}
