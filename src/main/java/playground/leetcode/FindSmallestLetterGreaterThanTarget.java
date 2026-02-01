package playground.leetcode;

import java.util.Arrays;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        //This is suboptimal; finding the minimum larger than target should do the trick.
        char first = letters[0];
        Arrays.sort(letters);
        int pos = Arrays.binarySearch(letters, target);

        if (pos < 0) {
            pos = -pos - 1;
        } else {
            pos++;
            while (pos < letters.length && letters[pos] == target) {
                pos++;
            }
        }

        if (pos >= letters.length) {
            return first;
        }

        return letters[pos];
    }

}
