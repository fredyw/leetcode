package leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Problem237 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        // TODO:
    }

    public static void main(String[] args) {
        Problem237 prob = new Problem237();
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        prob.deleteNode(head.next.next);
    }
}
