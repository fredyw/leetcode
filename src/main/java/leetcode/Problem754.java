package leetcode;

/**
 * https://leetcode.com/problems/reach-a-number/
 */
public class Problem754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public static void main(String[] args) {
        Problem754 prob = new Problem754();
        System.out.println(prob.reachNumber(0)); // 0
        System.out.println(prob.reachNumber(1)); // 1
        System.out.println(prob.reachNumber(2)); // 3
        System.out.println(prob.reachNumber(3)); // 2
        System.out.println(prob.reachNumber(4)); // 3
        System.out.println(prob.reachNumber(5)); // 5
        System.out.println(prob.reachNumber(6)); // 3
        System.out.println(prob.reachNumber(7)); // 5
        System.out.println(prob.reachNumber(8)); // 4
        System.out.println(prob.reachNumber(9)); // 5
    }
}
