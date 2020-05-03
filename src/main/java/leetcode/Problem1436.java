package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/destination-city/
 */
public class Problem1436 {
    public String destCity(List<List<String>> paths) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1436 prob = new Problem1436();
        System.out.println(prob.destCity(Arrays.asList(
            Arrays.asList("London","New York"),
            Arrays.asList("New York","Lima"),
            Arrays.asList("Lima","Sao Paulo")
        ))); // "Sao Paulo"
        System.out.println(prob.destCity(Arrays.asList(
            Arrays.asList("B","C"),
            Arrays.asList("D","B"),
            Arrays.asList("C","A")
        ))); // "A"
        System.out.println(prob.destCity(Arrays.asList(
            Arrays.asList("A","Z")
        ))); // "Z"
    }
}
