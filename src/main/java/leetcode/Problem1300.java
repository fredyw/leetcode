package leetcode;

/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 */
public class Problem1300 {
    public int findBestValue(int[] arr, int target) {
        int max = 0;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            max = Math.max(max, num);
        }
        int answer = sum / arr.length;
        return answer;
    }

    public static void main(String[] args) {
        Problem1300 prob = new Problem1300();
//        System.out.println(prob.findBestValue(new int[]{4,9,3}, 10)); // 3
//        System.out.println(prob.findBestValue(new int[]{2,3,5}, 10)); // 5
//        System.out.println(prob.findBestValue(new int[]{60864,25176,27249,21296,20204}, 56803)); // 11361
//        System.out.println(prob.findBestValue(new int[]{10,10,10}, 10)); // 3
//        System.out.println(prob.findBestValue(new int[]{1,1,1}, 10)); // 1
//        System.out.println(prob.findBestValue(new int[]{1,2,1}, 10)); // 2
        System.out.println(prob.findBestValue(new int[]{1,2,3}, 7)); // 3
    }
}
