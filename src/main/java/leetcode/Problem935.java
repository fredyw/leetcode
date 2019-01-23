package leetcode;

/**
 * https://leetcode.com/problems/knight-dialer/
 */
public class Problem935 {
    public int knightDialer(int N) {
        // TODO
        // 1 -> [6, 8]
        // 2 -> [7, 9]
        // 3 -> [4, 8]
        // 4 -> [0, 3, 9]
        // 5 -> []
        // 6 -> [0, 1, 7]
        // 7 -> [2, 6]
        // 8 -> [1, 3]
        // 9 -> [2, 4]
        // 0 -> [4, 6]
        return 0;
    }

    public static void main(String[] args) {
        Problem935 prob = new Problem935();
        System.out.println(prob.knightDialer(1)); // 10
        System.out.println(prob.knightDialer(2)); // 20
        System.out.println(prob.knightDialer(3)); // 46
        System.out.println(prob.knightDialer(5000)); // 406880451
    }
}
