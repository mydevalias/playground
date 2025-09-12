package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SortVowelsInString {

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public String sortVowels(String s) {
        List<Character> all = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                all.add(c);
            }
        }
        all.sort(Character::compareTo);
        StringBuilder sb = new StringBuilder(s.length());
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                sb.append(all.get(j));
                j++;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
