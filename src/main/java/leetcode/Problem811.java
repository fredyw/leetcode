package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */
public class Problem811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            String[] d = domain.split("\\.");
            String str = "";
            for (int i = d.length - 1; i >= 0; i--) {
                str = d[i] + ((str.isEmpty()) ? "" : ".") + str;
                if (map.containsKey(str)) {
                    map.put(str, map.get(str) + count);
                } else {
                    map.put(str, count);
                }
            }
        }
        List<String> result = new ArrayList<>();
        map.forEach((domain, count) -> {
            result.add(count + " " + domain);
        });
        return result;
    }
}
