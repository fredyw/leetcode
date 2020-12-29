package leetcode;

/**
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */
public class Problem1704 {
    public boolean halvesAreAlike(String s) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1704 prob = new Problem1704();
        System.out.println(prob.halvesAreAlike("book")); // true
        System.out.println(prob.halvesAreAlike("textbook")); // true
        System.out.println(prob.halvesAreAlike("MerryChristmas")); // false
        System.out.println(prob.halvesAreAlike("AbCdEfGh")); // true
    }
}
