package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/linked-list-random-node/
 */
public class Problem382 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        private final List<Integer> values = new ArrayList<>();
        private final Random random = new Random();

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            for (ListNode node = head; node != null; node = node.next) {
                values.add(node.val);
            }
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int randomIdx = random.nextInt(values.size());
            return values.get(randomIdx);
        }
    }
}
