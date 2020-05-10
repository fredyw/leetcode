package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 */
public class Problem1441 {
    public List<String> buildArray(int[] target, int n) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1441 prob = new Problem1441();
        System.out.println(prob.buildArray(new int[]{1,3}, 3)); // ["Push","Push","Pop","Push"]
        System.out.println(prob.buildArray(new int[]{1,2,3}, 3)); // ["Push","Push","Push"]
        System.out.println(prob.buildArray(new int[]{1,2}, 4)); // ["Push","Push"]
        System.out.println(prob.buildArray(new int[]{2,3,4}, 4)); // ["Push","Pop","Push","Push","Push"]
    }
}
