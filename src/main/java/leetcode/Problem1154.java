package leetcode;

import java.time.LocalDate;

/**
 * https://leetcode.com/problems/day-of-the-year/
 */
public class Problem1154 {
    public int dayOfYear(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfYear();
    }

    public static void main(String[] args) {
        Problem1154 prob = new Problem1154();
        System.out.println(prob.dayOfYear("2019-01-09")); // 9
        System.out.println(prob.dayOfYear("2019-02-10")); // 41
        System.out.println(prob.dayOfYear("2003-03-01")); // 60
        System.out.println(prob.dayOfYear("2004-03-01")); // 61
    }
}
