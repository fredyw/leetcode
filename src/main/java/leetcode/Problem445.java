package leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/
 */
public class Problem445 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Num n1 = getNumber(l1);
        Num n2 = getNumber(l2);
        long sum = n1.n + n2.n;
        // TODO
        return null;
    }

    private static class Num {
        private long n;
        private int digit;

        public Num(long n, int digit) {
            this.n = n;
            this.digit = digit;
        }
    }

    private static Num getNumber(ListNode node) {
        if (node == null) {
            return new Num(0, 1);
        }
        Num num = getNumber(node.next);
        num.n += (node.val * num.digit);
        num.digit *= 10;
        return num;
    }

    public static void main(String[] args) {
        Problem445 prob = new Problem445();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(prob.addTwoNumbers(l1, l2));
    }
}
