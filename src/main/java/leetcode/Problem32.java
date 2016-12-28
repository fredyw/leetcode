package leetcode;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class Problem32 {
    public int longestValidParentheses(String s) {
        int[] nCloses = new int[s.length()];
        int n = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            char c = s.charAt(j);
            if (c == ')') {
                nCloses[j] = ++n;
            } else {
                nCloses[j] = n;
            }
        }
//        System.out.println(Arrays.toString(nCloses));
        int max = 0;
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            int nextI = i + 1;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') {
                    count++;
                    if (nCloses[j] < count) {
                        break;
                    }
                } else {
                    if (count <= 0) {
                        break;
                    }
                    count--;
                }
                if (count == 0) {
                    max = Math.max(max, j - i + 1);
                    nextI = j + 1;
                }
            }
            i = nextI;
        }
        return max;
    }

    public static void main(String[] args) {
        Problem32 prob = new Problem32();
        System.out.println(prob.longestValidParentheses("(()")); // 2
        System.out.println(prob.longestValidParentheses(")()())")); // 4
        System.out.println(prob.longestValidParentheses("(")); // 0
        System.out.println(prob.longestValidParentheses("()(())")); // 6
        System.out.println(prob.longestValidParentheses("((())))")); // 6
        System.out.println(prob.longestValidParentheses("()(()(")); // 2
        System.out.println(prob.longestValidParentheses(")()()(")); // 4
        System.out.println(prob.longestValidParentheses("()((())")); // 4
        System.out.println(prob.longestValidParentheses("()(())")); // 6
        System.out.println(prob.longestValidParentheses("()()(()(((()))()))()))))()(())))()(()())()()()))())))())())))(()()()))))()((()(())(())))((()())(()()()((((()(())))))((()()((())(())(()(())))))()()())(())(()())((()())()(((())))()(()()))")); // 96
        System.out.println(prob.longestValidParentheses(")((()()((((()((((())(())(((()((((())(()((())())())(()))))))))))))(())(()())((())))))(((((()))())))(()()))(())))((()()(()()()()())))()(())((())()(())(((()())((())))(())))()())))))())()())())(((()")); // 108
    }
}
