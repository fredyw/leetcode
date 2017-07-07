package leetcode;

/**
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class Problem556 {
    public int nextGreaterElement(int n) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem556 prob = new Problem556();
        System.out.println(prob.nextGreaterElement(12)); // 21
        System.out.println(prob.nextGreaterElement(21)); // -1
        System.out.println(prob.nextGreaterElement(14526)); // 14562
        System.out.println(prob.nextGreaterElement(14526)); // 14562
        System.out.println(prob.nextGreaterElement(1452)); // 1524
        System.out.println(prob.nextGreaterElement(14520)); // 15024
        System.out.println(prob.nextGreaterElement(1002)); // 1020
        System.out.println(prob.nextGreaterElement(1233)); // 1323
        System.out.println(prob.nextGreaterElement(4321)); // -1
    }
}
