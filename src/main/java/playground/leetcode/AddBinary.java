package playground.leetcode;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        a = reverseString(a);
        b = reverseString(b);
        int c = 0;
        int size = Math.max(a.length(), b.length());
        for (int i = 0; i < size; i++) {
            int aa = 0;
            int bb = 0;
            if (i < a.length()) {
                aa = a.charAt(i) - '0';
            }
            if (i < b.length()) {
                bb = b.charAt(i) - '0';
            }
            int sum = aa + bb + c;
            int curent = sum % 2;
            c = sum / 2;
            sb.append(curent);
        }
        if (c > 0) {
            sb.append(c);
        }
        return sb.reverse().toString();

    }

    public static String reverseString(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
