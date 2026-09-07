package playground.leetcode3;

public class DistinctSubsequences {

    String s;
    String t;
    Integer[][] memo;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        this.memo = new Integer[s.length() + 1][t.length() + 1];
        return bk(0, 0);
    }

    private int bk(int sindex, int tindex) {
        if (tindex == t.length()) {
            return 1;
        }
        if (sindex == s.length()) {
            return 0;
        }
        if (memo[sindex][tindex] != null) {
            return memo[sindex][tindex];
        }
        int ret = 0;
        if (s.charAt(sindex) == t.charAt(tindex)) {
            ret += bk(sindex + 1, tindex + 1);
        }
        ret += bk(sindex + 1, tindex);

        memo[sindex][tindex] = ret;
        return ret;
    }

}
