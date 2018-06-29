package leetcode;

/**
 * https://leetcode.com/problems/mirror-reflection/
 */
public class Problem858 {
    public int mirrorReflection(int p, int q) {
        // TODO
        if (q == 0) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem858 prob = new Problem858();
        System.out.println(prob.mirrorReflection(2, 1)); // 2
        System.out.println(prob.mirrorReflection(2, 0)); // 0
        System.out.println(prob.mirrorReflection(3, 1)); // 1
        System.out.println(prob.mirrorReflection(4, 1)); // 2
        System.out.println(prob.mirrorReflection(3, 2)); // 0
        System.out.println(prob.mirrorReflection(5, 3)); // 1
    }
}
