package playground.leetcode;

public class FindKthBitinNthBinaryString {

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for (int i = 1; i < n; i++) {
            sb.append("1");
            for (int j = i - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
        }
        return sb.charAt(k);
    }


}
