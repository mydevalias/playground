package playground.leetcode;

public class Largest3SameDigitNumberString {

    public String largestGoodInteger(String num) {
        int max = -1;
        int i = 0;
        while (i < num.length() - 2) {
            char c = num.charAt(i);
            int currentInt = c - '0';
            if (currentInt > max) {
                if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                    max = currentInt;
                    i += 2;
                }
            }
            if (max == 9) {
                break;
            }
            i++;
        }
        if (max == -1) {
            return "";
        }
        String s = String.valueOf(max);
        return s + s + s;
    }

    public static void main(String[] args) {
        var lst = new Largest3SameDigitNumberString();
        System.out.println(lst.largestGoodInteger("6777133339"));
    }
}
