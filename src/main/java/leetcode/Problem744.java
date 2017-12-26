package leetcode;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class Problem744 {
    public char nextGreatestLetter(char[] letters, char target) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem744 prob = new Problem744();
        System.out.println(prob.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a')); // c
        System.out.println(prob.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c')); // f
        System.out.println(prob.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd')); // f
        System.out.println(prob.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g')); // j
        System.out.println(prob.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j')); // c
        System.out.println(prob.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k')); // c
    }
}
