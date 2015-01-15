package leetcode;

/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Problem24 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
        
        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public ListNode swapPairs(ListNode head) {
        // TODO: to be implemented
        return head;
    }
    
    private static void print(ListNode head) {
        for (ListNode n = head; n != null; n = n.next) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Problem24 prob = new Problem24();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        print(prob.swapPairs(head));
    }
}
