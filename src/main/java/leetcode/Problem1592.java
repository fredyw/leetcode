package leetcode;

/**
 * https://leetcode.com/problems/rearrange-spaces-between-words/
 */
public class Problem1592 {
    public String reorderSpaces(String text) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1592 prob = new Problem1592();
        System.out.println(prob.reorderSpaces("  this   is  a sentence ")); // "this   is   a   sentence"
        System.out.println(prob.reorderSpaces(" practice   makes   perfect")); // "practice   makes   perfect "
        System.out.println(prob.reorderSpaces("hello   world")); // "hello   world"
        System.out.println(prob.reorderSpaces("  walks  udp package   into  bar a")); // "walks  udp  package  into  bar  a "
        System.out.println(prob.reorderSpaces("a")); // "a"
    }
}
