package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/adding-two-negabinary-numbers/
 */
public class Problem1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        boolean positive = true;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int sum = positive ? arr1[i] + arr2[j] + carry : -(arr1[i] + arr2[j]) + carry;
            if (positive && sum < 0) {
                carry = -1;
            } else if (!positive && sum > 0) {
                carry = 1;
            } else {
                carry = sum / 2;
            }
            list.add(Math.abs(sum % 2));
            positive = !positive;
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = positive ? arr1[i] + carry : -arr1[i] + carry;
            if (positive && sum < 0) {
                carry = -1;
            } else if (!positive && sum > 0) {
                carry = 1;
            } else {
                carry = sum / 2;
            }
            list.add(Math.abs(sum % 2));
            positive = !positive;
            i--;
        }
        while (j >= 0) {
            int sum = positive ? arr2[j] + carry : -arr2[j] + carry;
            if (positive && sum < 0) {
                carry = -1;
            } else if (!positive && sum > 0) {
                carry = 1;
            } else {
                carry = sum / 2;
            }
            list.add(Math.abs(sum % 2));
            positive = !positive;
            j--;
        }
        while (carry != 0) {
            int sum = carry;
            if (positive && sum < 0) {
                carry = -1;
            } else if (!positive && sum > 0) {
                carry = 1;
            } else {
                carry = sum / 2;
            }
            list.add(Math.abs(sum % 2));
            positive = !positive;
        }
        int size = list.size();
        int k = list.size() - 1;
        while (k >= 0 && list.get(k) == 0) {
            k--;
            size--;
        }
        if (size == 0) {
            return new int[]{0};
        }
        // Remove all the leading zeros.
        int[] answer = new int[size];
        int l = 0;
        for (; k >= 0; k--) {
            answer[l++] = list.get(k);
        }
        return answer;
    }
}
