package leetcode;

/**
 * https://leetcode.com/problems/bulb-switcher-ii/
 */
public class Problem672 {
    public int flipLights(int n, int m) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem672 prob = new Problem672();
        System.out.println(prob.flipLights(1, 0)); // 1
        System.out.println(prob.flipLights(1, 1)); // 2
        System.out.println(prob.flipLights(2, 1)); // 3
        System.out.println(prob.flipLights(3, 1)); // 4
        System.out.println(prob.flipLights(3, 2)); // 7
        System.out.println(prob.flipLights(3, 3)); // 8
        System.out.println(prob.flipLights(3, 4)); // 8
        System.out.println(prob.flipLights(15, 1)); // 4
        System.out.println(prob.flipLights(15, 2)); // 7
        System.out.println(prob.flipLights(15, 3)); // 8
    }
}
