package leetcode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Problem23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (ListNode n : lists) {
            if (result == null) {
                result = n;
            } else {
                result = merge(result, n);
            }
        }
        return result;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode n1 = node1;
        ListNode n2 = node2;
        ListNode resultHead = null;
        ListNode result = null;
        while (true) {
            while (n1 != null && n2 != null && n1.val <= n2.val) {
                if (result == null) {
                    result = n1;
                    resultHead = result;
                } else {
                    result.next = n1;
                    result = result.next;
                }
                n1 = n1.next;
            }
            if (n1 == null) {
                break;
            }
            while (n1 != null && n2 != null && n1.val > n2.val) {
                if (result == null) {
                    result = n2;
                    resultHead = result;
                } else {
                    result.next = n2;
                    result = result.next;
                }
                n2 = n2.next;
            }
            if (n2 == null) {
                break;
            }
        }
        while (n1 != null) {
            if (result == null) {
                result = n1;
                resultHead = result;
            } else {
                result.next = n1;
                result = result.next;
            }
            n1 = n1.next;
        }
        while (n2 != null) {
            if (result == null) {
                result = n2;
                resultHead = result;
            } else {
                result.next = n2;
                result = result.next;
            }
            n2 = n2.next;
        }
        return resultHead;
    }

    private static void print(ListNode node) {
        for (ListNode n = node; n != null; n = n.next) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem23 prob = new Problem23();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(7);
        list2.next.next = new ListNode(9);
        list2.next.next.next = new ListNode(10);
        list2.next.next.next.next = new ListNode(12);

        ListNode list3 = new ListNode(4);
        list3.next = new ListNode(6);
        list3.next.next = new ListNode(8);
        list3.next.next.next = new ListNode(11);

        ListNode result = prob.mergeKLists(new ListNode[]{list1, list2, list3});
        print(result);

        result = prob.mergeKLists(new ListNode[]{list1, null, list3});
        print(result);
    }
}
