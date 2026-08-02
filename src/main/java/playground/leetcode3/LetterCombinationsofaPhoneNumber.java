package playground.leetcode3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> digitToLetters = new HashMap<>();
        digitToLetters.put('2', new char[]{'a', 'b', 'c'});
        digitToLetters.put('3', new char[]{'d', 'e', 'f'});
        digitToLetters.put('4', new char[]{'g', 'h', 'i'});
        digitToLetters.put('5', new char[]{'j', 'k', 'l'});
        digitToLetters.put('6', new char[]{'m', 'n', 'o'});
        digitToLetters.put('7', new char[]{'p', 'q', 'r', 's'});
        digitToLetters.put('8', new char[]{'t', 'u', 'v'});
        digitToLetters.put('9', new char[]{'w', 'x', 'y', 'z'});

        List<StringBuilder> sbs = new ArrayList<>();
        sbs.add(new StringBuilder());
        for (char d : digits.toCharArray()) {
            char[] current = digitToLetters.get(d);
            ArrayList<StringBuilder> newSbs = new ArrayList<>();
            for (char toadd : current) {
                for (StringBuilder sb : sbs) {
                    StringBuilder e = new StringBuilder(sb);
                    newSbs.add(e.append(toadd));
                }
            }
            sbs = newSbs;
        }

        List<String> ret = new ArrayList<>();
        for (StringBuilder sb : sbs) {
            ret.add(sb.toString());
        }
        return ret;

    }

}
