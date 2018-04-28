package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/ambiguous-coordinates/
 */
public class Problem816 {
    public List<String> ambiguousCoordinates(String S) {
        // TODO
        List<String> result = new ArrayList<>();
        for (int i = 2; i < S.length() - 1; i++) {
            String first = S.substring(1, i);
            String second = S.substring(i, S.length() - 1);

            System.out.println(first + " -> " + second);
        }
        return result;
    }

    private static List<String> makeDecimals(String s) {
        return null;
    }

    public static void main(String[] args) {
        Problem816 prob = new Problem816();
//        System.out.println(prob.ambiguousCoordinates("(123)")); // "(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"
        System.out.println(prob.ambiguousCoordinates("(00011)")); // "(0.001, 1)", "(0, 0.011)"
//        System.out.println(prob.ambiguousCoordinates("(0123)")); // "(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"
//        System.out.println(prob.ambiguousCoordinates("(100)")); // "(10, 0)"
    }
}
