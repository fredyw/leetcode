package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class Problem433 {
    public int minMutation(String start, String end, String[] bank) {
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        boolean found = false;
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            String s = queue.remove();
            count++;
            if (s.equals(end)) {
                found = true;
                break;
            }
            for (int i = 0; i < s.length(); i++) {
                char[] tmp = s.toCharArray();
                for (char c : chars) {
                    tmp[i] = c;
                }
                String adjacent = new String(tmp);
                if (set.contains(adjacent)) {
                    queue.add(adjacent);
                }
            }
        }
        return (found) ? count : -1;
    }

    public static void main(String[] args) {
        Problem433 prob = new Problem433();
        System.out.println(prob.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"})); // 1
//        System.out.println(prob.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"})); // 2
//        System.out.println(prob.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"})); // 3
    }
}
