package leetcode;

/**
 * https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class Problem433 {
    public int minMutation(String start, String end, String[] bank) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem433 prob = new Problem433();
        System.out.println(prob.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"})); // 1
        System.out.println(prob.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"})); // 2
        System.out.println(prob.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"})); // 3
    }
}
