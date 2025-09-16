package playground.leetcode;


public class FindMostFrequentVowelConsonant {

    public static int max(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public int maxFreqSum(String s) {
        int[] valsVowel = new int['z' - 'a' + 1];
        int[] valsConsonant = new int['z' - 'a' + 1];
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                valsVowel[c - 'a']++;
            } else {
                valsConsonant[c - 'a']++;
            }
        }
        return max(valsVowel) + max(valsConsonant);
    }

}
