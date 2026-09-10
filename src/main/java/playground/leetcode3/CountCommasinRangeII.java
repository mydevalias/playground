package playground.leetcode3;

public class CountCommasinRangeII {
    public long countCommas(long n) {
        if (n < 1000) {
            return 0;
        }
        long ret = 0;
        if (n < 1_000_000) {
            ret += (n - 1000 + 1) * 1;
            return ret;
        } else {
            ret += (999_999 - 1000 + 1) * 1;
        }
        if (n < 1_000_000_000) {
            ret += (n - 1_000_000 + 1) * 2;
            return ret;
        } else {
            ret += (999_999_999L - 1_000_000 + 1) * 2;
        }
        if (n < 1_000_000_000_000L) {
            ret += (n - 1_000_000_000L + 1) * 3;
            return  ret;
        } else {
            ret += (999_999_999_999L - 1_000_000_000L + 1) * 3;
        }
        if (n < 1_000_000_000_000_000L) {
            ret += (n - 1_000_000_000_000L + 1) * 4;
            return  ret;
        } else {
            ret += (999_999_999_999_999L - 1_000_000_000_000L + 1) * 4;
        }

        ret += (n - 1_000_000_000_000_000L + 1) * 5;
        return ret;
    }
}
