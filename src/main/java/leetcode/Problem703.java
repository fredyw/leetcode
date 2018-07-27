package leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class Problem703 {
    private static class KthLargest {

        public KthLargest(int k, int[] nums) {
            // TODO
        }

        public int add(int val) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3)); // returns 4
        System.out.println(kthLargest.add(5)); // returns 5
        System.out.println(kthLargest.add(10)); // returns 5
        System.out.println(kthLargest.add(9)); // returns 8
        System.out.println(kthLargest.add(4)); // returns 8
    }
}
