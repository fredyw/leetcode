package leetcode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Problem142 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        return null;
    }
    
    public static void main(String[] args) {
        Problem142 prob = new Problem142();
        
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        
        System.out.println(prob.detectCycle(node1).val);
    }
}
