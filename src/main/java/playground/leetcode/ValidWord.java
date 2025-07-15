package playground.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-word/description/
 */
public class ValidWord {
    
    private static final Set<Character> VOWELS = new HashSet<>();

    static {

        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');


        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }

    public boolean isValid(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        if (word.length() < 3) {
            return false;
        }
        boolean vowel = false;
        boolean consonant = false;
        for (int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if ((c >= 'A' && c <= 'z')) {
                if (VOWELS.contains(c)) {
                    vowel = true;
                } else {
                    consonant = true;
                }
                continue;
            }
            return false;
        }
        return vowel && consonant;
    }
}
