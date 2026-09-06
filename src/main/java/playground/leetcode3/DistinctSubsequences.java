package playground.leetcode3;

public class DistinctSubsequences {

    String s;
    String t;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        return bk(0, 0);
    }

    private int bk(int sindex, int tindex) {
        if (tindex == t.length()) {
            return 1;
        }
        if (sindex == s.length()) {
            return 0;
        }
        int ret = 0;
        if(s.charAt(sindex) == t.charAt(tindex)){
            ret +=bk(sindex+1, tindex+1);
        }
        ret +=bk(sindex+1, tindex);

        return ret;
    }

}
