package leetcode;

/**
 * https://leetcode.com/problems/rle-iterator/
 */
public class Problem900 {
    private static class RLEIterator {
        public RLEIterator(int[] A) {
        }

        public int next(int n) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        RLEIterator iterator = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(iterator.next(2)); // 8
        System.out.println(iterator.next(1)); // 8
        System.out.println(iterator.next(1)); // 5
        System.out.println(iterator.next(2)); // -1
    }
}
