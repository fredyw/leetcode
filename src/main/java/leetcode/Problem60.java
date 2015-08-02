package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class Problem60 {
	public String getPermutation(int n, int k) {
		int[] factorials = new int[n];
		for (int i = 0; i < n; i++) {
			factorials[i] = factorial(i);
		}
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = n-1; i >= 0; i--) {
			int idx = k / factorials[i];
			if (k % factorials[i] == 0) {
				idx -= 1;
			}
			sb.append(numbers.get(idx));
			numbers.remove(idx);
			k = k - (idx * factorials[i]);
		}
		return sb.toString();
	}
	
    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
