package playground.leetcode;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int vd = 1;
        int hd = 0;

        int v = 0;
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb[v].append(c);
            v = Math.min(v + vd, numRows - 1);
            v = Math.max(0, v);
            h = h + hd;
            if (v + 1 == numRows || v == 0) {
                vd = vd * -1;
                hd = (hd + 1) % 2;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(sb[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zc = new ZigzagConversion();
        System.out.println(zc.convert("PAYPALISHIRING", 3));
        System.out.println(zc.convert("PAYPALISHIRING", 4));
        System.out.println(zc.convert("AB", 1));
    }

}
