package leetcode;

/**
 * https://leetcode.com/problems/goal-parser-interpretation/
 */
public class Problem1678 {
    public String interpret(String command) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1678 prob = new Problem1678();
        System.out.println(prob.interpret("G()(al)")); // "Goal"
        System.out.println(prob.interpret("G()()()()(al)")); // "Gooooal"
        System.out.println(prob.interpret("(al)G(al)()()G")); // "alGalooG"
    }
}
