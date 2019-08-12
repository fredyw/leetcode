package leetcode;

import java.time.LocalDate;

/**
 * https://leetcode.com/problems/day-of-the-year/
 */
public class Problem1154 {
    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }
}
