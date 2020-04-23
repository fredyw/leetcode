package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
 */
public class Problem1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap</* table */ Integer,
            TreeMap</* food */ String, /* count */ Integer>> map = new TreeMap<>();
        TreeSet<String> foodItems = new TreeSet<>();
        for (List<String> order : orders) {
            Integer table = Integer.valueOf(order.get(1));
            String food = order.get(2);
            foodItems.add(food);
            if (!map.containsKey(table)) {
                map.put(table, new TreeMap<>());
            }
            map.get(table).put(food, map.get(table).getOrDefault(food, 0) + 1);
        }
        List<List<String>> answer = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String food : foodItems) {
            header.add(food);
        }
        answer.add(header);
        for (Map.Entry<Integer, TreeMap<String, Integer>> e : map.entrySet()) {
            List<String> row = new ArrayList<>();
            row.add("" + e.getKey()); // table
            for (int i = 1; i < header.size(); i++) {
                row.add("" + e.getValue().getOrDefault(header.get(i), 0)); // count
            }
            answer.add(row);
        }
        return answer;
    }
}
