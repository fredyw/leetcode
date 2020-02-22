package leetcode;

/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 */
public class Problem1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int size = s.length();
        int prev = 0;
        int answer = 0;
        int cost = maxCost;
        for (int cur = 0; cur < size; cur++) {
            int diff = Math.abs(s.charAt(cur) - t.charAt(cur));
            cost -= diff;
            if (cost < 0) {
                cost = maxCost;
                answer = Math.max(answer, cur - prev);
                prev = cur;
            }
        }
        if (cost >= 0) {
            answer = Math.max(answer, size - 1 - prev);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1208 prob = new Problem1208();
//        System.out.println(prob.equalSubstring("abcd", "bcdf", 3)); // 3
//        System.out.println(prob.equalSubstring("abaace", "bcxbdf", 3)); // 3
        System.out.println(prob.equalSubstring("abcd", "cdef", 3)); // 1
//        System.out.println(prob.equalSubstring("abcd", "acde", 0)); // 1
//        System.out.println(prob.equalSubstring("abcd", "bxdf", 2)); // 1
    }
}
