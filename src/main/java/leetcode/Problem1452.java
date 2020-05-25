package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/
 */
public class Problem1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Set<String>[] companies = new Set[favoriteCompanies.size()];
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            companies[i] = new HashSet<>();
            for (String company : favoriteCompanies.get(i)) {
                companies[i].add(company);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean subset = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (companies[j].containsAll(companies[i])) {
                    subset = true;
                }
            }
            if (!subset) {
                answer.add(i);
            }
        }
        return answer;
    }
}
