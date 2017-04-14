package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class Problem138 {
    private static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        for (RandomListNode node = head; node != null; node = node.next) {
            RandomListNode copy = new RandomListNode(node.label);
            map.put(node, copy);
        }
        RandomListNode copyHead = null;
        RandomListNode copyNode = null;
        for (RandomListNode node = head; node != null; node = node.next) {
            RandomListNode copy = map.get(node);
            if (copyHead == null) {
                copyHead = copy;
                copyNode = copy;
            } else {
                copyNode.next = copy;
                copyNode = copyNode.next;
            }
            if (node.random != null) {
                RandomListNode randomCopy = map.get(node.random);
                copyNode.random = randomCopy;
            }
        }
        return copyHead;
    }
}
