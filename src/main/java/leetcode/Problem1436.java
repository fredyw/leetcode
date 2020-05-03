package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/destination-city/
 */
public class Problem1436 {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        Set<String> destinations = new HashSet<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
            destinations.add(path.get(1));
        }
        String answer = null;
        for (String destination : destinations) {
            if (!map.containsKey(destination)) {
                answer = destination;
                break;
            }
        }
        return answer;
    }
}
