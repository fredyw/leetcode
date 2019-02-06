package leetcode;

/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 */
public class Problem825 {
    public int numFriendRequests(int[] ages) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem825 prob = new Problem825();
        System.out.println(prob.numFriendRequests(new int[]{16, 16})); // 2
        System.out.println(prob.numFriendRequests(new int[]{16, 17, 18})); // 2
        System.out.println(prob.numFriendRequests(new int[]{20, 30, 100, 110, 120})); // 3
    }
}
