package leetcode;

/**
 * https://leetcode.com/problems/string-compression/
 */
public class Problem443 {
    public int compress(char[] chars) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem443 prob = new Problem443();
        System.out.println(prob.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'})); // 6
        System.out.println(prob.compress(new char[]{'a'})); // 1
        System.out.println(prob.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'})); // 4
    }
}
