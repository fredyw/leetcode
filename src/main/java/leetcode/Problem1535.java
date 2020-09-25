package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 */
public class Problem1535 {
    public int getWinner(int[] arr, int k) {
        int answer;
        int first = 0;
        int last = arr.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            int second = (first + 1) % arr.length;
            if (arr[first] > arr[second]) {
                int count = map.getOrDefault(arr[first], 0) + 1;
                if (count == k) {
                    answer = arr[first];
                    break;
                }
                map.put(arr[first], count);
                int tmp = arr[second];
                arr[second] = arr[first];
                arr[first] = tmp;
            } else {
                int count = map.getOrDefault(arr[second], 0) + 1;
                if (count == k) {
                    answer = arr[first];
                    break;
                }
                map.put(arr[second], count);

            }
            first = (first + 1) % arr.length;
            last = (last + 1) % arr.length;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1535 prob = new Problem1535();
//        System.out.println(prob.getWinner(new int[]{2,1,3,5,4,6,7}, 2)); // 5
//        System.out.println(prob.getWinner(new int[]{3,2,1}, 10)); // 3
//        System.out.println(prob.getWinner(new int[]{1,9,8,2,3,7,6,4,5}, 7)); // 9
        System.out.println(prob.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99}, 1000000000)); // 99
    }
}
