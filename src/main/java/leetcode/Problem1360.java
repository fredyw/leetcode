package leetcode;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * https://leetcode.com/problems/number-of-days-between-two-dates/
 */
public class Problem1360 {
    public int daysBetweenDates(String date1, String date2) {
        String[] splitDate1 = date1.split("-");
        String[] splitDate2 = date2.split("-");
        LocalDate d1 = LocalDate.of(
            Integer.parseInt(splitDate1[0]),
            Integer.parseInt(splitDate1[1]),
            Integer.parseInt(splitDate1[2]));
        LocalDate d2 = LocalDate.of(
            Integer.parseInt(splitDate2[0]),
            Integer.parseInt(splitDate2[1]),
            Integer.parseInt(splitDate2[2]));
        return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }
}
