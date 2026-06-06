package playground.leetcode2;

public class TotalWavinessofNumbersinRangeI {

    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for (int i = num1; i <= num2; i++) {
            res += count(i);
        }
        return res;
    }

    private int count(int n) {
        int c = 0;
        int prev = -1, current = -1, next = -1;
        while (n != 0) {
            if (prev > -1 && current > -1 && next > -1) {
                if (current > prev && current > next) {
                    c++;
                }
                if (current < prev && current < next) {
                    c++;
                }
            }
            prev = current;
            current = next;
            next = n % 10;
            n = n / 10;
        }
        if (prev > -1 && current > -1 && next > -1) {
            if (current > prev && current > next) {
                c++;
            }
            if (current < prev && current < next) {
                c++;
            }
        }
        return c;
    }

}
