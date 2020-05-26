package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class Problem1456 {
    public int maxVowels(String s, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1456 prob = new Problem1456();
        System.out.println(prob.maxVowels("abciiidef", 3)); // 3
        System.out.println(prob.maxVowels("aeiou", 2)); // 2
        System.out.println(prob.maxVowels("leetcode", 3)); // 2
        System.out.println(prob.maxVowels("rhythms", 3)); // 4
        System.out.println(prob.maxVowels("tryhard", 4)); // 4
    }
}
