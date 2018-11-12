package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reorder-log-files/
 */
public class Problem937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        for (String log : logs) {
            String s = log.split(" ")[1];
            if (s.charAt(0) >= 'a' && s.charAt(0) <= 'z') {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }
        letterLogs.sort((a, b) -> {
            String aId = a.substring(0, a.indexOf(" "));
            String bId = b.substring(0, b.indexOf(" "));
            String aLetters = a.substring(a.indexOf(" "));
            String bLetters = b.substring(b.indexOf(" "));
            int cmp = aLetters.compareTo(bLetters);
            if (cmp == 0) {
                return aId.compareTo(bId);
            }
            return cmp;
        });
        List<String> result = new ArrayList<>();
        result.addAll(letterLogs);
        result.addAll(digitLogs);
        return result.toArray(new String[0]);
    }
}
