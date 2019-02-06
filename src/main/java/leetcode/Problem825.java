package leetcode;

/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/
 */
public class Problem825 {
    public int numFriendRequests(int[] ages) {
        int answer = 0;
        for (int i = 0; i < ages.length; i++) {
            for (int j = i + 1; j < ages.length; j++) {
                if (accept(ages[i], ages[j])) {
                    answer++;
                }
                if (accept(ages[j], ages[i])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean accept(int a, int b) {
        return (!((a <= 0.5 * b + 7) || (a > b) || (a > 100 && b < 100)));
    }

    public static void main(String[] args) {
        Problem825 prob = new Problem825();
        System.out.println(prob.numFriendRequests(new int[]{16, 16})); // 2
        System.out.println(prob.numFriendRequests(new int[]{16, 17, 18})); // 2
        System.out.println(prob.numFriendRequests(new int[]{20, 30, 100, 110, 120})); // 3
    }
}
