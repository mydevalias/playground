package playground.leetcode;

public class MinimumPenaltyForAShop {

    public int bestClosingTime(String customers) {
        int pen = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y') {
                pen++;
            }
        }

        int minPen = pen;
        int toClose = 0;
        int open = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                pen--;
            } else {
                open++;
            }

            int totalPen = pen + open;
            if (totalPen < minPen) {
                minPen = totalPen;
                toClose = i + 1;
            }
        }

        return toClose;
    }

}
