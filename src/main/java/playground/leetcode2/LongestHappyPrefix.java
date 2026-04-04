package playground.leetcode2;

public class LongestHappyPrefix {
    public String longestPrefix(String s) {

        for (int i = 0; i < s.length() / 2; i++) {
            int right = s.length() - 1 - i;
            if(s.charAt(i)!=s.charAt(right)){
                return s.substring(0, i);
            }
        }
        return "";
    }


}
