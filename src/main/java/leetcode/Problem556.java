package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class Problem556 {
    public int nextGreaterElement(int n) {
        boolean found = false;
        char[] c = Integer.toString(n).toCharArray();
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] > c[i - 1]) {
                found = true;
                int nextGreater = c.length - 1;
                for (int j = c.length - 1; j > 0; j--) {
                    if (c[i - 1] < c[j]) {
                        nextGreater = j;
                        break;
                    }
                }
                char tmp = c[nextGreater];
                c[nextGreater] = c[i - 1];
                c[i - 1] = tmp;
                Arrays.sort(c, i, c.length);
                break;
            }
        }
        if (!found) {
            return -1;
        }
        return Integer.parseInt(new String(c));
    }

    public static void main(String[] args) {
        Problem556 prob = new Problem556();
        System.out.println(prob.nextGreaterElement(12)); // 21
        System.out.println(prob.nextGreaterElement(21)); // -1
        System.out.println(prob.nextGreaterElement(14526)); // 14562
        System.out.println(prob.nextGreaterElement(1452)); // 1524
        System.out.println(prob.nextGreaterElement(14520)); // 15024
        System.out.println(prob.nextGreaterElement(1002)); // 1020
        System.out.println(prob.nextGreaterElement(1233)); // 1323
        System.out.println(prob.nextGreaterElement(4321)); // -1
        System.out.println(prob.nextGreaterElement(12750)); // 15027
        System.out.println(prob.nextGreaterElement(16750)); // 17056
    }
}
