package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class Problem386 {
    public List<Integer> lexicalOrder(int n) {
        TreeSet<Integer> result = new TreeSet<>((x, y) -> x.toString().compareTo(y.toString()));
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Problem386 prob = new Problem386();
        System.out.println(prob.lexicalOrder(13));
        System.out.println(prob.lexicalOrder(5000));
//        System.out.println(prob.lexicalOrder(5000000));
    }
}
