package leetcode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class Problem147 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public ListNode insertionSortList(ListNode head) {
        int size = 0;
        for (ListNode n = head; n != null; n = n.next) {
            size++;
        }
        ListNode newHead = head;
        int x = 1;
        for (ListNode n = head; n != null; n = n.next) {
            System.out.println("swapping head: " + newHead + " with " + n);
            newHead = swapWithHead(newHead, n);
            print(newHead);
//        System.out.println("newhead=" + newHead + ", tmp=" + tmp);
            ListNode prev = null;
            ListNode current = newHead;
            for (int i = 0; i < x; i++) {
//            System.out.println("current=" + current);
                if (prev == null) {
                    if (newHead.val > current.next.val) {
                        newHead = swap(newHead, prev, current);
                    }
                } else {
                    if (prev.next.val > current.next.val) {
                        newHead = swap(newHead, prev, current);
                    }
                }
                prev = current;
                current = current.next;
            }
            x++;
        }

//        for (int x = 0; x <= size-2; x++) {
//            for (int i = x; i >= 0; i--) {
//                ListNode prev = null;
//                ListNode current = newHead;
//                for (int j = 0; j < i; j++) {
//                    prev = current;
//                    current = current.next;
//                }
//                if (prev == null) {
//                    if (head.val > current.next.val) {
//                        newHead = swap(newHead, prev, current);
//                    }
//                } else {
//                    if (prev.next.val > current.next.val) {
//                        newHead = swap(newHead, prev, current);
//                    }
//                }
//            }
//        }
        return newHead;
    }

    private ListNode swap(ListNode head, ListNode n1, ListNode n2) {
        if (n2.next == null) {
            return head;
        }
        if (n1 == null) {
            ListNode tmp1 = n2.next;
            head.next = null;
            ListNode tmp2 = tmp1.next;
            head.next = tmp2;
            tmp1.next = head;
            return tmp1;
        }
        ListNode tmp1 = n1.next;
        n1.next = n2.next;
        tmp1.next = null;
        ListNode tmp2 = n1.next.next;
        n1.next.next = tmp1;
        tmp1.next = tmp2;
        return head;
    }

    private ListNode swapWithHead(ListNode head, ListNode n1) {
        if (head == n1) {
            return swap(head, null, n1);
        }
        ListNode n1Swap = n1.next;
        ListNode n1Rest = n1Swap.next;
        n1.next = null;
        ListNode tmpHead = head;
        n1Swap.next = head.next;
        n1.next = tmpHead;
        tmpHead.next = n1Rest;
        return n1Swap;

//        ListNode tmp1 = n1.next;
//        ListNode tmp2 = head.next;
//        ListNode tmp3 = tmp1.next;
//        tmp2.next = tmp1.next;
//        head.next = null;
//        n1.next = head;
//        tmp1.next = tmp2;
//        head.next = tmp3;
//        return tmp1;
    }

    private void print(ListNode node) {
        for (ListNode n = node; n != null; n = n.next) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem147 prob = new Problem147();

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(0);

//        ListNode head = new ListNode(3);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(0);
//
//        ListNode head = new ListNode(0);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(4);

//        head = prob.swap(head, null, head);
//        head = prob.swap(head, head, head.next);
//        head = prob.swap(head, head.next, head.next.next);
//        head = prob.swap(head, head.next.next, head.next.next.next);
//        head = prob.swap(head, head.next.next.next, head.next.next.next.next);

//        prob.print(head);
//        System.out.println("swapping...");
//        head = prob.swapWithHead(head, head);
//        prob.print(head);

        prob.print(head);
        System.out.println("sorting...");
        ListNode newHead = prob.insertionSortList(head);
        prob.print(newHead);
    }
}
