package playground.leetcode3;

public class MaximizeActiveSectionwithTradeI {

    public int maxActiveSectionsAfterTrade(String s) {
        int zeroPrev = -1;
        int zeroCurrent = 0;
        int i = 0;
        int best = Integer.MIN_VALUE;
        while (i < s.length()) {
            if (s.charAt(i) == '0') {
                zeroCurrent++;
                if (zeroPrev > -1) {
                    best = Math.max(zeroCurrent + zeroPrev, best);
                }
                i++;
            } else {
                if (zeroCurrent > 0) {
                    //we just switched to one;
                    zeroPrev = zeroCurrent;
                    zeroCurrent = 0;
                }
                while ( i < s.length() && s.charAt(i) == '1') {
                    i++;
                }
            }
        }
        int cones = 0;
        for ( i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cones++;
            }
        }
        return cones+ Math.max(best, 0);
    }

    private static int suffixWrong(String s) {
        int suffixZero[] = new int[s.length()];
        int suffixOnes[] = new int[s.length()];

        int prevOne = 0;
        int prevZero = 0;
        for (int i = s.length() - 1; i > -0; i--) {
            if (s.charAt(i) == '0') {
                prevOne = 0;
                prevZero++;

            } else {
                prevOne++;
                prevZero = 0;
            }

            suffixZero[i] = prevZero;
            suffixOnes[i] = prevOne;
        }
        int res = s.contains("1") ? 1 : s.length();
        int curZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                curZero++;
            }
        }
        return res;
    }

}
