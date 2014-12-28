package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 */
public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        return pascalsTriangle(rowIndex, 1, result);
    }
    
    private List<Integer> pascalsTriangle(int rowIndex, int n, List<Integer> result) {
        if (n == rowIndex+1) {
            return result;
        }
        List<Integer> currentList = new ArrayList<>();
        currentList.add(1);
        for (int i = 0; i < result.size()-1; i++) {
            int value = result.get(i) + result.get(i+1);
            currentList.add(value);
        }
        currentList.add(1);
        
        return pascalsTriangle(rowIndex, n+1, currentList);
    }
}
