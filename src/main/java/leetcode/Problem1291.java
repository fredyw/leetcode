package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sequential-digits/
 */
public class Problem1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        String next = Long.toString(low);
        out:
        for (int i = 0; i < next.length() - 1; i++) {
            if (next.charAt(i + 1) - next.charAt(i) != 1) {
                int size = next.length();
                int j = 0;
                while (true) {
                    int x = next.charAt(0) - '0' + j++;
                    next = "" + x++;
                    for (int k = 0; k < size - 1; k++) {
                        if (x >= 10) {
                            size++;
                            next = "";
                            for (int l = 0; l < size; l++) {
                                next += (l + 1);
                            }
                            break;
                        }
                        next += x++;
                    }
                    if (Long.parseLong(next) >= low) {
                        break out;
                    }
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        int size = next.length();
        out:
        while (Long.parseLong(next) <= high) {
            answer.add(Integer.valueOf(next));
            int x = next.charAt(0) - '0' + 1;
            next = "" + x++;
            for (int i = 0; i < size - 1; i++) {
                if (x >= 10) {
                    size++;
                    next = "";
                    for (int j = 0; j < size; j++) {
                        next += (j + 1);
                    }
                    continue out;
                }
                next += x++;
            }
        }
        return answer;
    }
}
