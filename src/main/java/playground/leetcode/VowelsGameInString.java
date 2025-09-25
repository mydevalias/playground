package playground.leetcode;

public class VowelsGameInString {


    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                return true;
            }
        }
        return false;
    }

}
