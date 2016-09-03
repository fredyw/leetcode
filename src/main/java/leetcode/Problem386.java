package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers/
 */
public class Problem386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            lexicalOrder(n, "" + i, result);
        }
        return result;
    }

    private void lexicalOrder(int n, String accu, List<Integer> result) {
        int num = Integer.parseInt(accu);
        if (num > n) {
            return;
        }
        result.add(num);
        for (int i = 0; i <= 9; i++) {
            lexicalOrder(n, accu + i, result);
        }
    }

    public static void main(String[] args) {
        Problem386 prob = new Problem386();
        System.out.println(prob.lexicalOrder(13));
        System.out.println(prob.lexicalOrder(5000));
        System.out.println(prob.lexicalOrder(5000000));
    }
}
