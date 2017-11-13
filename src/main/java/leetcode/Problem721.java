package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/accounts-merge/
 */
public class Problem721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Map<String, String>>> map = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            if (account.size() > 1) {
                List<Map<String, String>> list = map.get(name);
                if (list == null) {
                    list = new ArrayList<>();
                }
                Map<String, String> found = null;
                outer:
                for (Map<String, String> m : list) {
                    for (int i = 1; i < account.size(); i++) {
                        if (m.containsKey(account.get(i))) {
                            found = m;
                            break outer;
                        }
                    }
                }
                if (found != null) {
                    String val = new ArrayList<>(found.values()).get(0);
                    for (int i = 1; i < account.size(); i++) {
                        found.put(account.get(i), val);
                    }
                } else {
                    Map<String, String> m = new HashMap<>();
                    String email = account.get(1);
                    m.put(email, email);
                    for (int i = 2; i < account.size(); i++) {
                        m.put(account.get(i), email);
                    }
                    if (!map.containsKey(name)) {
                        List<Map<String, String>> newList = new ArrayList<>();
                        newList.add(m);
                        map.put(name, newList);
                    } else {
                        map.get(name).add(m);
                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<Map<String, String>>> e : map.entrySet()) {
            String name = e.getKey();
            List<Map<String, String>> list = e.getValue();
            for (Map<String, String> m : list) {
                List<String> account = new ArrayList<>();
                account.add(name);
                TreeSet<String> set = new TreeSet<>(m.keySet());
                for (String email : set) {
                    account.add(email);
                }
                result.add(account);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem721 prob = new Problem721();
//        System.out.println(prob.accountsMerge(Arrays.asList(
//            Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}),
//            Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}),
//            Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}),
//            Arrays.asList(new String[]{"Mary", "mary@mail.com"})
//        ))); // [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
        System.out.println(prob.accountsMerge(Arrays.asList(
            Arrays.asList(new String[]{"David","David0@m.co","David1@m.co"}),
            Arrays.asList(new String[]{"David","David3@m.co","David4@m.co"}),
            Arrays.asList(new String[]{"David","David4@m.co","David5@m.co"}),
            Arrays.asList(new String[]{"David","David2@m.co","David3@m.co"}),
            Arrays.asList(new String[]{"David","David1@m.co","David2@m.co"})
        ))); // [["David","David0@m.co","David1@m.co","David2@m.co","David3@m.co","David4@m.co","David5@m.co"]]
    }
}
