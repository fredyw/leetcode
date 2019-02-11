package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */
public class Problem989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        String kStr = Integer.toString(K);
        int[] k = new int[kStr.length()];
        for (int i = 0; i < kStr.length(); i++) {
            k[i] = kStr.charAt(i) - '0';
        }
        List<Integer> answer = new ArrayList<>();
        int i = A.length - 1;
        int j = k.length - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = A[i] + k[j] + carry;;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            answer.add(sum % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = A[i] + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            answer.add(sum % 10);
            i--;
        }
        while (j >= 0) {
            int sum = k[j] + carry;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            answer.add(sum % 10);
            j--;
        }
        if (carry == 1) {
            answer.add(1);
        }
        Collections.reverse(answer);
        return answer;
    }
}
