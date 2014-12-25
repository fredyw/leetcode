package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/pascals-triangle/
 */
public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        pascalsTriangle(numRows, 1, result);
        return result;
    }
    
    private void pascalsTriangle(int numRows, int n, List<List<Integer>> result) {
        if (n >= numRows) {
            return;
        }
        List<Integer> prevList = (result.size() == 0) ?
            new ArrayList<Integer>() : result.get(result.size()-1);
        List<Integer> currentList = new ArrayList<>();
        currentList.add(1);
        for (int i = 0; i < prevList.size()-1; i++) {
            int value = prevList.get(i) + prevList.get(i+1);
            currentList.add(value);
        }
        currentList.add(1);
        result.add(currentList);
        
        pascalsTriangle(numRows, n+1, result);
    }
}
