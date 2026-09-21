package playground.leetcode3;

public class ReverseDegreeofaString {

    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += pc(s.charAt(i)) * (i + 1);
        }
        return sum;
    }

    private int pc(char c) {
        return  26 - (c - 'a');
    }

}
