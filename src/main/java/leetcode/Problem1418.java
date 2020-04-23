package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/
 */
public class Problem1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1418 prob = new Problem1418();
        System.out.println(prob.displayTable(
            Arrays.asList(
                Arrays.asList("David","3","Ceviche"),
                Arrays.asList("Corina","10","Beef Burrito"),
                Arrays.asList("David","3","Fried Chicken"),
                Arrays.asList("Carla","5","Water"),
                Arrays.asList("Carla","5","Ceviche"),
                Arrays.asList("Rous","3","Ceviche")
            ))); // [["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
        System.out.println(prob.displayTable(
            Arrays.asList(
                Arrays.asList("James","12","Fried Chicken"),
                Arrays.asList("Ratesh","12","Fried Chicken"),
                Arrays.asList("Amadeus","12","Fried Chicken"),
                Arrays.asList("Adam","1","Canadian Waffles"),
                Arrays.asList("Brianna","1","Canadian Waffles")
            ))); // [["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
        System.out.println(prob.displayTable(
            Arrays.asList(
                Arrays.asList("Laura","2","Bean Burrito"),
                Arrays.asList("Jhon","2","Beef Burrito"),
                Arrays.asList("Melissa","2","Soda")
            ))); // [["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
    }
}
