package playground.leetcode3;

public class ShortestandLexicographicallySmallestBeautifulString {

    public String shortestBeautifulSubstring(String s, int k) {
        String ret = null;
        int left = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
            if (count == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }
                String candidate = s.substring(left, i + 1);
                if (ret == null
                        || candidate.length() < ret.length()
                        || (candidate.length() == ret.length() && candidate.compareTo(ret) < 0)) {
                    ret = candidate;
                }
            }
        }
        return ret == null ? "" : ret;
    }

}
