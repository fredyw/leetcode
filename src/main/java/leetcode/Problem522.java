package leetcode;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/
 */
public class Problem522 {
    public int findLUSlength(String[] strs) {
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                String a = strs[i];
                String b = strs[j];
                if (a.length() < b.length()) {
                    a = strs[j];
                    b = strs[i];
                }
                int count = 0;
                for (int x = 0; x < a.length(); x++) {
                    int y = 0;
                    while (y < b.length() && a.charAt(x) != b.charAt(y)) {
                        y++;
                    }
                    if (y < b.length()) {
                        count++;
                    }
                }
                max = Math.max(max, a.length() - count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem522 prob = new Problem522();
//        System.out.println(prob.findLUSlength(new String[]{"aba", "cdc", "eae"})); // 3
        System.out.println(prob.findLUSlength(new String[]{"aba", "eae"})); // 2
//        System.out.println(prob.findLUSlength(new String[]{"aabbcc", "aabbcc","cb","abc"})); // 2
    }
}
