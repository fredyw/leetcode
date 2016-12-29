package leetcode;

import java.math.BigInteger;

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
        char[] sum = n1.n.add(n2.n).toString().toCharArray();
        ListNode head = null;
        ListNode node = null;
        for (int i = 0; i < sum.length; i++) {
            if (i == 0) {
                head = new ListNode(sum[i] - '0');
                node = head;
            } else {
                node.next = new ListNode(sum[i] - '0');
                node = node.next;
            }
        }
        return head;
    }

    private static class Num {
        private BigInteger n;
        private BigInteger digit;

        public Num(BigInteger n, BigInteger digit) {
            this.n = n;
            this.digit = digit;
        }
    }

    private static Num getNumber(ListNode node) {
        if (node == null) {
            return new Num(BigInteger.ZERO, BigInteger.ONE);
        }
        Num num = getNumber(node.next);
        num.n = num.n.add(BigInteger.valueOf(node.val).multiply(num.digit));
        num.digit = num.digit.multiply(BigInteger.TEN);
        return num;
    }
}
