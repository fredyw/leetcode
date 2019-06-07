package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
            if (positive) {
                int sum = arr1[i] + arr2[j] + carry;
                carry = sum / 2;
                list.add(sum % 2);
                positive = false;
            } else {
                int sum = -(arr1[i] + arr2[j]) + carry;
                carry = sum / 2;
                list.add(Math.abs(sum % 2));
                positive = true;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (positive) {
                int sum = arr1[i] + carry;
                carry = sum / 2;
                list.add(sum % 2);
                positive = true;
            } else {
                int sum = -arr1[i] + carry;
                carry = sum / 2;
                list.add(Math.abs(sum % 2));
                positive = false;
            }
            i--;
        }
        while (j >= 0) {
            if (positive) {
                int sum = arr2[j] + carry;
                carry = sum / 2;
                list.add(Math.abs(sum % 2));
                positive = true;
            } else {
                int sum = -arr2[j] + carry;
                carry = sum / 2;
                list.add(Math.abs(sum % 2));
                positive = false;
            }
            j--;
        }
        int size = list.size();
        int k = list.size() - 1;
        while (k >= 0 && list.get(k) == 0) {
            k--;
            size--;
        }
        int[] answer = new int[size];
        int l = 0;
        for (; k >= 0; k--) {
            answer[l++] = list.get(k);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1073 prob = new Problem1073();
//        System.out.println(Arrays.toString(prob.addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1}))); // [1,0,0,0,0]
//        System.out.println(Arrays.toString(prob.addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1, 1}))); // [1,1,0]
        System.out.println(Arrays.toString(prob.addNegabinary(new int[]{1, 1, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 1, 0}))); // [1,1,0,0,0,1,0,1,1]
    }
}
