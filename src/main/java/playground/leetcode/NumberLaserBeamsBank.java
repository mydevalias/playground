package playground.leetcode;

public class NumberLaserBeamsBank {

    public int count(String s) {
        int c = 0;
        for (char cc : s.toCharArray()) {
            if (cc == '1') {
                c++;
            }
        }
        return c;
    }

    public int numberOfBeams(String[] bank) {
        int laser = 0;
        int prev = 0;
        for (int i = 0; i < bank.length; i++) {
            int c = count(bank[i]);
            laser = laser + prev * c;
            if (c != 0) {
                prev = c;
            }
        }
        return laser;
    }


}
