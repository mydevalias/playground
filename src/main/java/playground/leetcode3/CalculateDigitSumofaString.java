package playground.leetcode3;

public class CalculateDigitSumofaString {

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            s = remap(s, k) ;
        }
        return s;
    }

    private String remap(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int val = 0;
        for (char c : s.toCharArray()) {
            i++;
            val = val + (c - '0');
            if(i%k==0){
                sb.append(val);
                val = 0;
            }
        }
        if (i % k != 0) {
            sb.append(val);
        }
        return sb.toString();
    }

}
