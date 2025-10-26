package playground.leetcode;

public class CalculateMoneyLeetcodeBank {

    public int totalMoney(int n) {
        int res = 0;
        int mondays = 0;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                mondays++;
            }
            res = res + mondays + (i % 7);
        }
        return res;
    }

}
