package playground.leetcode2;

public class AngleBetweenHandsofaClock {

    public double angleClock(int hour, int minutes) {
        if (hour == 12) {
            hour = 0;
        }
        double ha = 360d * ((double) hour / 12d) + 30 * (minutes / 60d);
        double ma = 360d * (minutes / 60d);

        double diff = Math.abs(ha - ma);
        return Math.min(diff, 360d - diff);
    }

}
