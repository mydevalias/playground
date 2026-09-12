package playground.leetcode3;

import java.util.Arrays;

public class SmallestPalindromicRearrangementI {

    public String smallestPalindrome(String s) {
        char c[] = new char[s.length() / 2];
        for (int i = 0; i < s.length() / 2; i++) {
            c[i] = s.charAt(i);
        }
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        for (var cc : c) {
            sb.append(cc);
        }
        if(s.length()%2 ==1){
            sb.append(s.charAt(s.length() / 2+1));
        }
        return sb.toString();
    }

}
