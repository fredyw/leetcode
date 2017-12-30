package leetcode;

/**
 * https://leetcode.com/problems/open-the-lock/description/
 */
public class Problem753 {
    public int openLock(String[] deadends, String target) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem753 prob = new Problem753();
        System.out.println(prob.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202")); // 6
        System.out.println(prob.openLock(new String[]{"8888"}, "0009")); // 1
        System.out.println(prob.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888")); // -1
        System.out.println(prob.openLock(new String[]{"0000"}, "8888")); // -1
    }
}
