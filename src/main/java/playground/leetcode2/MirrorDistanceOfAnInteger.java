package playground.leetcode2;

public class MirrorDistanceOfAnInteger {

    public int mirrorDistance(int n) {
        return Math.abs(n-mirror(n));
    }

    public int mirror(int val) {
        int res = 0;
        while (val > 0) {
            int rem = val % 10;
            res = res * 10 + rem;
            val = val / 10;
        }
        return res;
    }

}
