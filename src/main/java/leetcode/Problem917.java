package leetcode;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class Problem917 {
    public String reverseOnlyLetters(String S) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem917 prob = new Problem917();
        System.out.println(prob.reverseOnlyLetters("ab-cd")); // "dc-ba"
        System.out.println(prob.reverseOnlyLetters("a-bC-dEf-ghIj")); // "j-Ih-gfE-dCba"
        System.out.println(prob.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // "Qedo1ct-eeLg=ntse-T!"
    }
}
