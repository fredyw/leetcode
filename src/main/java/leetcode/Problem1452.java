package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 */
public class Problem1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1452 prob = new Problem1452();
        System.out.println(prob.peopleIndexes(Arrays.asList(
            Arrays.asList("leetcode","google","facebook"),
            Arrays.asList("google","microsoft"),
            Arrays.asList("google","facebook"),
            Arrays.asList("google"),
            Arrays.asList("amazon")
        ))); // [0,1,4]
        System.out.println(prob.peopleIndexes(Arrays.asList(
            Arrays.asList("leetcode","google","facebook"),
            Arrays.asList("google","microsoft"),
            Arrays.asList("google","facebook"),
            Arrays.asList("google"),
            Arrays.asList("amazon"),
            Arrays.asList("leetcode", "facebook")
        ))); // [0,1,4]
        System.out.println(prob.peopleIndexes(Arrays.asList(
            Arrays.asList("leetcode","google","facebook"),
            Arrays.asList("leetcode","amazon"),
            Arrays.asList("facebook","google")
        ))); // [0,1]
        System.out.println(prob.peopleIndexes(Arrays.asList(
            Arrays.asList("leetcode"),
            Arrays.asList("google"),
            Arrays.asList("facebook"),
            Arrays.asList("amazon")
        ))); // [0,1,2,3]
    }
}
