package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/kill-process/#/description
 */
public class Problem582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem582 prob = new Problem582();
        System.out.println(prob.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5)); // [5, 10]
    }
}
