package leetcode;

/**
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Problem160 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        for (ListNode n = headA; n != null; n = n.next) {
            sizeA++;
        }
        int sizeB = 0;
        for (ListNode n = headB; n != null; n = n.next) {
            sizeB++;
        }
        int diff = Math.abs(sizeA - sizeB);
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < diff; i++) {
                nodeA = nodeA.next;
            }
        } else if (sizeA < sizeB) {
            for (int i = 0; i < diff; i++) {
                nodeB = nodeB.next;
            }
        }
        for (ListNode a = nodeA, b = nodeB; a != null || b != null; a = a.next, b = b.next) {
            if (a == b) {
                return a;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Problem160 prob = new Problem160();
        
        ListNode intersection = new ListNode(3);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);
        
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = intersection;
        
        for (ListNode n = list1; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
        
        ListNode list2 = new ListNode(100);
        list2.next = new ListNode(200);
        list2.next.next = new ListNode(300);
        list2.next.next.next = intersection;
        
        for (ListNode n = list2; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
        
        ListNode result = prob.getIntersectionNode(list1, list2);
        for (ListNode n = result; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }
}
