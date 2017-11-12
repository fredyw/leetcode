package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class Problem721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, UnionFind> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            if (account.size() > 1) {
                UnionFind uf = new UnionFind();
                String email = account.get(1);
                for (int i = 2; i < account.size(); i++) {
                    uf.connect(email, account.get(i));
                }
                map.put(name, uf);
            }
        }
        return null;
    }

    private static class UnionFind {
        private final Map<String, String> map = new HashMap<>();

        public void connect(String a, String b) {
            if (!map.containsKey(a)) {
                map.put(a, a);
            }
            if (!map.containsKey(b)) {
                map.put(b, b);
            }
            if (map.get(a).equals(map.get(b))) {
                return;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue().equals(map.get(a))) {
                    map.put(entry.getKey(), map.get(b));
                }
            }
        }

        public boolean isConnected(String a, String b) {
            if (!map.containsKey(a)) {
                return false;
            }
            if (!map.containsKey(b)) {
                return false;
            }
            return map.get(a).equals(map.get(b));
        }
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
