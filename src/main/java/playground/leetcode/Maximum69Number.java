package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Maximum69Number {
    public int maximum69Number(int num) {

        List<Integer> all = new ArrayList<>();
        while (num > 0) {
            int d = num % 10;
            num = num / 10;
            all.add(d);
        }

        var fs = -1;
        for (int i = all.size()-1; i >0; i--) {
            if ( all.get(i) == 6) {
                fs = i;
                break;
            }
        }
        if (fs != -1) {
            all.set(fs, 9);
        }

        int res = 0;
        for (int i = all.size()-1; i >0; i--) {
            res = res * 10 + all.get(i);
        }
        return res;
    }

    private static int wrong(int num) {
        if (num < 10) {
            return num;
        }
        int s = 0;
        int n = 0;
        while (num > 0) {
            int d = num % 10;
            num = num / 10;
            if (d == 9) {
                n++;
            } else {
                s++;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res * 10 + 9;
        }
        for (int i = 0; i < s; i++) {
            res = res * 10 + 6;
        }
        return res;
    }

    public static void main(String[] args) {
        Maximum69Number x = new Maximum69Number();
//        System.out.println(x.maximum69Number(9669));
        System.out.println(x.maximum69Number(6));//969
    }
}
