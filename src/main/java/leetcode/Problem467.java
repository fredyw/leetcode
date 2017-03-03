package leetcode;

/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 */
public class Problem467 {
    public int findSubstringInWraproundString(String p) {
        int max = 0;
        int count = 0;
        for (int prev = 0, current = 1; current < p.length(); prev++, current++) {
            if ((p.charAt(prev) + 1 - 'a') % 26 == p.charAt(current) - 'a') {
                count += current - prev;
            } else {
                count = 1;
            }
            prev = current;
            max = Math.max(max, count);
        }
        int sum = 0;
        // TODO
        return sum;
    }

    public static void main(String[] args) {
        Problem467 prob = new Problem467();
//        System.out.println(prob.findSubstringInWraproundString("a")); // 1
        System.out.println(prob.findSubstringInWraproundString("cac")); // 2
//        System.out.println(prob.findSubstringInWraproundString("zab")); // 6
//        System.out.println(prob.findSubstringInWraproundString("cab")); // 4
//        System.out.println(prob.findSubstringInWraproundString("dabd")); // 4
//        System.out.println(prob.findSubstringInWraproundString("zaba")); // 6
//        System.out.println(prob.findSubstringInWraproundString("abcd")); // 10
//        System.out.println(prob.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyz")); // 351
//        System.out.println(prob.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz")); // 11843
    }
}
