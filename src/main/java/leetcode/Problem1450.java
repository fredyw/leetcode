package leetcode;

/**
 * https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class Problem1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1450 prob = new Problem1450();
        System.out.println(prob.busyStudent(new int[]{1,2,3}, new int[]{3,2,7}, 4)); // 1
        System.out.println(prob.busyStudent(new int[]{4}, new int[]{4}, 4)); // 1
        System.out.println(prob.busyStudent(new int[]{4}, new int[]{4}, 5)); // 0
        System.out.println(prob.busyStudent(new int[]{1,1,1,1}, new int[]{1,3,2,4}, 7)); // 0
        System.out.println(prob.busyStudent(new int[]{9,8,7,6,5,4,3,2,1}, new int[]{10,10,10,10,10,10,10,10,10}, 5)); // 5
    }
}
