package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 */
public class Problem990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        List<String> notEquals = new ArrayList<>();
        for (String equation : equations) {
            char left = equation.charAt(0);
            char right = equation.charAt(3);
            if (equation.substring(1, 3).equals("==")) {
                uf.union(left, right);
            } else {
                if (left == right) {
                    return false;
                }
                notEquals.add(equation);
            }
        }
        for (String notEqual : notEquals) {
            char left = notEqual.charAt(0);
            char right = notEqual.charAt(3);
            if (uf.array[left - 'a'] == null || uf.array[right - 'a'] == null) {
                continue;
            }
            if (uf.array[left - 'a'] == uf.array[right - 'a']) {
                return false;
            }
        }
        return true;
    }

    private static class UnionFind {
        private final Character[] array = new Character[26];

        private void union(char a, char b) {
            if (array[a - 'a'] == null) {
                array[a - 'a'] = a;
            }
            if (array[b - 'a'] == null) {
                array[b - 'a'] = b;
            }
            if (array[a - 'a'] != null && array[b - 'a'] != null &&
                array[a - 'a'] == array[b - 'a']) {
                return;
            }
            Character val = array[a - 'a'];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == val) {
                    array[i] = array[b - 'a'];
                }
            }
        }
    }
}
