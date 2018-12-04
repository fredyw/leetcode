package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class Problem950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> index = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            index.add(i);
        }
        int[] answer = new int[deck.length];
        Arrays.sort(deck);
        for (int i = 0; i < deck.length; i++) {
            answer[index.removeFirst()] = deck[i];
            if (!index.isEmpty()) {
                index.addLast(index.removeFirst());
            }
        }
        return answer;
    }
}
