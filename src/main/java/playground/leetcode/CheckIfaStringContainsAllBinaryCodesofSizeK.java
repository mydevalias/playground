package playground.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {

    public boolean hasAllCodes(String s, int k) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
        }
        return seen.size() == (1 << k);
    }

    public boolean slow(String s, int k) {
        int size = k;
        for (int i = 0; i < (1 << k); i++) {
            String search = padBinary(Integer.toBinaryString(i), size);
            if(!s.contains(search)){
                return false;
            }
        }
        return true;
    }

    public static String padBinary(String binary, int size) {
        return String.format("%" + size + "s", binary).replace(' ', '0');
    }


}
