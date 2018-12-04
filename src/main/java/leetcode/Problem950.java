package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class Problem950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] answer = new int[deck.length];
        int i = 0;
        int j = 2;
        int k = 0;
        int count = 0;
        while (count < deck.length) {
            System.out.println("start: " + k + ", increment: " + j);
            for (; i < deck.length && k < answer.length; k += j, i++) {
                answer[k] = deck[i];
                count++;
            }
            System.out.println(Arrays.toString(answer));
            k = j - 1;
            j *= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem950 prob = new Problem950();
        System.out.println(Arrays.toString(
            prob.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7}))); // [2,13,3,11,5,17,7]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7, 20}))); // [2,11,3,17,5,13,7,20]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3}))); // [1,3,2]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3}))); // [1,2]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4}))); // [1,3,2,4]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5}))); // [1,5,2,4,3]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6}))); // [1,4,2,6,3,5]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7}))); // [1,6,2,5,3,7,4]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8}))); // [1,5,2,7,3,6,4,8]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}))); // [1,9,2,6,3,8,4,7,5]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))); // [1,6,2,10,3,7,4,9,5,8]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})));
//            // [1,8,2,13,3,9,4,12,5,10,6,14,7,11]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16})));
            // [1,9,2,13,3,10,4,15,5,11,6,14,7,12,8,16]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17})));
//            // [1,17,2,10,3,14,4,11,5,16,6,12,7,15,8,13,9]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18})));
//            // [1,10,2,18,3,11,4,15,5,12,6,17,7,13,8,16,9,14]
//        System.out.println(Arrays.toString(
//            prob.deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})));
//        // [1,11,2,16,3,12,4,20,5,13,6,17,7,14,8,19,9,15,10,18]
    }
}
