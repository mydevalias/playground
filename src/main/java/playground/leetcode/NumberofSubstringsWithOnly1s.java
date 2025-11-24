package playground.leetcode;

public class NumberofSubstringsWithOnly1s {
    private static final int MOD = 1000000007;

    public int numSub(String s) {
        int cs = -1;
        long sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (cs != -1) {
                    long len = i - cs;
                    sum = (sum + countSubstrings(len)) % MOD;
                    cs = -1;
                }
            } else {
                if (cs == -1) {
                    cs = i;
                }
            }
        }

        if (cs != -1) {
            long len = s.length() - cs;
            sum = (sum + countSubstrings(len)) % MOD;
        }

        return (int)sum;
    }

    private long countSubstrings(long n) {
        return (n * (n + 1) / 2) % MOD;
    }
}
