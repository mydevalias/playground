package playground.leetcode;

public class BinaryNumberWithAlternatingBits {


    public boolean hasAlternatingBits(int n) {
        Boolean expectOne = null;
        while (n > 0) {
            int last = n % 2;
            n = n / 2;
            if (expectOne == null) {
                expectOne = last != 1;
            } else {
                if (expectOne) {
                    if (last != 1) {
                        return false;
                    }
                } else {
                    if (last == 1) {
                        return false;
                    }
                }
                expectOne = !expectOne;
            }
        }
        return true;
    }

}
