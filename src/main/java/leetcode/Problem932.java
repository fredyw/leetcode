package leetcode;

/**
 * https://leetcode.com/problems/beautiful-array/
 */
public class Problem932 {
    public int[] beautifulArray(int N) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem932 prob = new Problem932();
        System.out.println(prob.beautifulArray(1)); // [1]
        System.out.println(prob.beautifulArray(2)); // [1,2]
        System.out.println(prob.beautifulArray(3)); // [1,3,2]
        System.out.println(prob.beautifulArray(4)); // [2,1,4,3]
        System.out.println(prob.beautifulArray(5)); // [3,1,2,5,4]
        System.out.println(prob.beautifulArray(6)); // [1,5,3,2,6,4]
    }
}
