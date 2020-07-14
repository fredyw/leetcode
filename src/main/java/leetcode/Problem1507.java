package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/reformat-date/
 */
public class Problem1507 {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        Matcher m = Pattern.compile("(\\d+)\\w+").matcher(split[0]);
        m.matches();
        return split[2] + "-" + getMonth(split[1]) + "-" + getDay(m.group(1));
    }

    private static String getDay(String day) {
        return day.length() == 1 ? "0" + day : day;
    }

    private static String getMonth(String month) {
        if (month.equals("Jan")) {
            return "01";
        } else if (month.equals("Feb")) {
            return "02";
        } else if (month.equals("Mar")) {
            return "03";
        } else if (month.equals("Apr")) {
            return "04";
        } else if (month.equals("May")) {
            return "05";
        } else if (month.equals("Jun")) {
            return "06";
        } else if (month.equals("Jul")) {
            return "07";
        } else if (month.equals("Aug")) {
            return "08";
        } else if (month.equals("Sep")) {
            return "09";
        } else if (month.equals("Oct")) {
            return "10";
        } else if (month.equals("Nov")) {
            return "11";
        }
        return "12";
    }
}
