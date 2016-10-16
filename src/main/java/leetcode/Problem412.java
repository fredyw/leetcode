package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fizz-buzz/
 */
public class Problem412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % 3 == 0 && n % 5 == 0) {
                result.add("FizzBuzz");
            } else if (n % 3 == 0) {
                result.add("Fizz");
            } else if (n % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(n));
            }
        }
        return result;
    }
}
