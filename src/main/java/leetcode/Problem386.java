package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class Problem386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }
        Collections.sort(result, (x, y) -> x.toString().compareTo(y.toString()));
        return result;
    }

    public static void main(String[] args) {
        Problem386 prob = new Problem386();
        System.out.println(prob.lexicalOrder(13));
        System.out.println(prob.lexicalOrder(5000000));
    }
}
