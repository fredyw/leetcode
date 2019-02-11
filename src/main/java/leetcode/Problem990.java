package leetcode;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
public class Problem990 {
    public boolean equationsPossible(String[] equations) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem990 prob = new Problem990();
        System.out.println(prob.equationsPossible(new String[]{"a==b", "b!=a"})); // false
        System.out.println(prob.equationsPossible(new String[]{"b==a", "a==b"})); // true
        System.out.println(prob.equationsPossible(new String[]{"a==b", "b==c", "a==c"})); // true
        System.out.println(prob.equationsPossible(new String[]{"a==b", "b!=c", "c==a"})); // false
        System.out.println(prob.equationsPossible(new String[]{"c==c", "b==d", "x!=z"})); // true
    }
}
