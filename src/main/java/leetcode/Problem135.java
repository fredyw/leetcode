package leetcode;

/**
 * https://leetcode.com/problems/candy/
 */
public class Problem135 {
    public int candy(int[] ratings) {
        int answer = 0;
        int i = 0;
        while (i + 1 < ratings.length) {
            // increasing
            int count = 1;
            while (i + 1 < ratings.length && ratings[i] < ratings[i + 1]) {
                i++;
                answer += ++count;
            }
            // equal
            while (i + 1 < ratings.length && ratings[i] == ratings[i + 1]) {
                i++;
                answer++;
            }
            // decreasing
            count = 1;
            while (i + 1 < ratings.length && ratings[i] > ratings[i + 1]) {
                i++;
                answer += ++count;
            }
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        Problem135 prob = new Problem135();
//        System.out.println(prob.candy(new int[]{1, 0, 2})); // 5
//        System.out.println(prob.candy(new int[]{1, 0, 2, 2})); // 6
//        System.out.println(prob.candy(new int[]{1, 1, 1, 1, 1})); // 5
//        System.out.println(prob.candy(new int[]{1, 2, 2})); // 4
//        System.out.println(prob.candy(new int[]{2, 2, 2})); // 3
//        System.out.println(prob.candy(new int[]{2, 3, 2})); // 4
//        System.out.println(prob.candy(new int[]{3, 2, 1, 2, 3})); // 11
//        System.out.println(prob.candy(new int[]{3, 2, 2, 3})); // 6
//        System.out.println(prob.candy(new int[]{3, 2, 2, 2, 3})); // 7
//        System.out.println(prob.candy(new int[]{1, 2, 2, 1})); // 6
//        System.out.println(prob.candy(new int[]{1, 2, 2, 2, 1})); // 7 
//        System.out.println(prob.candy(new int[]{4, 3, 2, 1})); // 10
//        System.out.println(prob.candy(new int[]{1, 2, 3, 4})); // 10
//        System.out.println(prob.candy(new int[]{1, 2, 3, 4, 4, 4, 3, 2, 1})); // 21
//        System.out.println(prob.candy(new int[]{1, 2, 3, 4, 3, 2, 1})); // 16
        System.out.println(prob.candy(new int[]{2, 3, 2, 1})); // 7
//        System.out.println(prob.candy(new int[]{2, 3, 3, 2, 1})); // 9
//        System.out.println(prob.candy(new int[]{2, 3, 3, 4, 5})); // 9
    }
}
