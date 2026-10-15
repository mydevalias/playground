package playground.leetcode3;

/**
 * https://leetcode.com/problems/maximize-sum-of-squares-of-digits/?envType=daily-question&envId=2026-10-14
 */
public class MaximizeSumofSquaresofDigits {

    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int nines = sum / 9;
        for (int i = 0; i < nines; i++) {
            sb.append("9");
        }
        int rem = sum % 9;
        if (rem > 0) {
            sb.append(rem);
        }
        while (sb.length() < num) {
            sb.append(0);
        }
        return sb.toString();
    }

}
