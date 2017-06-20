package leetcode;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class Problem621 {
    public int leastInterval(char[] tasks, int n) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem621 prob = new Problem621();
        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); // 8
        System.out.println(prob.leastInterval(new char[]{'A','A','A','B','B','B'}, 1)); // 6
        System.out.println(prob.leastInterval(new char[]{'A','B','B','B'}, 2)); // 7
        System.out.println(prob.leastInterval(new char[]{'A','B','B','B'}, 1)); // 5
    }
}
