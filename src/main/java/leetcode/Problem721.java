package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class Problem721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem721 prob = new Problem721();
        System.out.println(prob.accountsMerge(Arrays.asList(
            Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}),
            Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}),
            Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}),
            Arrays.asList(new String[]{"Mary", "mary@mail.com"})
        ))); // [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
    }
}
