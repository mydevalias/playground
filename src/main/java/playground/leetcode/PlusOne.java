package playground.leetcode;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            digits[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 1) {
            int[] nd = new int[digits.length + 1];
            nd[0] = 1;
//            for (int i = 1; i < nd.length; i++) {
//                nd[i] = digits[i - 1];
//            }
            System.arraycopy(digits, 0, nd, 1, digits.length);
            return nd;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne x = new PlusOne();
        System.out.println(Arrays.toString(x.plusOne(new int[]{9, 9})));
    }

}
