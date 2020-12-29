package leetcode;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class Problem1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1700 prob = new Problem1700();
        System.out.println(prob.countStudents(new int[]{1,1,0,0}, new int[]{0,1,0,1})); // 0
        System.out.println(prob.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1})); // 3
    }
}
