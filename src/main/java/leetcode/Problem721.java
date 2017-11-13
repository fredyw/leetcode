package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class Problem721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        for (List<String> account : accounts) {
            String name = account.get(0);
            String email = account.get(1);
            uf.connect(name, email, email);
            for (int i = 2; i < account.size(); i++) {
                uf.connect(name, email, account.get(i));
            }
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (Map.Entry<String, String[]> entry : uf.getMap().entrySet()) {
            String key = entry.getValue()[0] + "," + entry.getValue()[1];
            if (!map.containsKey(key)) {
                Set<String> set = new TreeSet<>();
                set.add(entry.getKey());
                map.put(key, set);
            } else {
                map.get(key).add(entry.getKey());
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(entry.getKey().split(",")[0]);
            for (String email : entry.getValue()) {
                list.add(email);
            }
            result.add(list);
        }
        return result;
    }

    public static class UnionFind {
        private final Map<String, String[]> map = new HashMap<>();

        public void connect(String x, String a, String b) {
            if (!map.containsKey(a)) {
                map.put(a, new String[]{x, a});
            }
            if (!map.containsKey(b)) {
                map.put(b, new String[]{x, b});
            }
            if (map.get(a)[1].equals(map.get(b)[1])) {
                return;
            }
            String oldValue = map.get(a)[1];
            String newValue = map.get(b)[1];
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                if (entry.getValue()[1].equals(oldValue)) {
                    map.put(entry.getKey(), new String[]{x, newValue});
                }
            }
        }

        public Map<String, String[]> getMap() {
            return map;
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
        System.out.println(prob.accountsMerge(Arrays.asList(
            Arrays.asList(new String[]{"David","David0@m.co","David1@m.co"}),
            Arrays.asList(new String[]{"David","David3@m.co","David4@m.co"}),
            Arrays.asList(new String[]{"David","David4@m.co","David5@m.co"}),
            Arrays.asList(new String[]{"David","David2@m.co","David3@m.co"}),
            Arrays.asList(new String[]{"David","David1@m.co","David2@m.co"})
        ))); // [["David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]
    }
}
