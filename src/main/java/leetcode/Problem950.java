package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class Problem950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] answer = new int[deck.length];
        System.out.println("sorted: " + Arrays.toString(deck));
        int n = deck.length / 2;
        if (deck.length % 2 != 0) {
            n++;
        }
        for (int i = 0, j = 0; i < n; i++, j += 2) {
            answer[j] = deck[i];
        }
        for (int i = n, j = 1; i < deck.length; i++, j += 2) {
            answer[j] = deck[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem950 prob = new Problem950();
        System.out.println(Arrays.toString(
            prob.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7}))); // [2,13,3,11,5,17,7]
        System.out.println(Arrays.toString(
            prob.deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7, 20}))); // [2,11,3,17,5,13,7,20]
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
    }
}
