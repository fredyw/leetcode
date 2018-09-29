package leetcode;

/**
 * https://leetcode.com/problems/reordered-power-of-2/
 */
public class Problem869 {
    public boolean reorderedPowerOf2(int N) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem869 prob = new Problem869();
        System.out.println(prob.reorderedPowerOf2(1)); // true
        System.out.println(prob.reorderedPowerOf2(10)); // false
        System.out.println(prob.reorderedPowerOf2(16)); // true
        System.out.println(prob.reorderedPowerOf2(24)); // false
        System.out.println(prob.reorderedPowerOf2(46)); // true
    }
}
