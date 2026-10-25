package playground.leetcode3;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CountDaysSpentTogether {

    private static final int NON_LEAP_YEAR = 2022;
    private static final DateTimeFormatter MM_DD = DateTimeFormatter.ofPattern("MM-dd");

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate aliceArrive = toDate(arriveAlice);
        LocalDate aliceLeave = toDate(leaveAlice);
        LocalDate bobArrive = toDate(arriveBob);
        LocalDate bobLeave = toDate(leaveBob);

        LocalDate start = aliceArrive.isAfter(bobArrive) ? aliceArrive : bobArrive;
        LocalDate end = aliceLeave.isBefore(bobLeave) ? aliceLeave : bobLeave;

        if (start.isAfter(end)) {
            return 0;
        }
        return (int) ChronoUnit.DAYS.between(start, end) + 1;
    }

    private LocalDate toDate(String mmdd) {
        return MonthDay.parse(mmdd, MM_DD).atYear(NON_LEAP_YEAR);
    }
}
