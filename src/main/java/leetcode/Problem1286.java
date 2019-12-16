package leetcode;

/**
 * https://leetcode.com/problems/iterator-for-combination/
 */
public class Problem1286 {
    private static class CombinationIterator {
        public CombinationIterator(String characters, int combinationLength) {
            // TODO
        }

        public String next() {
            // TODO
            return null;
        }

        public boolean hasNext() {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        CombinationIterator iter = new CombinationIterator("abc", 2);
        System.out.println(iter.next()); // returns "ab"
        System.out.println(iter.hasNext()); // returns true
        System.out.println(iter.next()); // returns "ac"
        System.out.println(iter.hasNext()); // returns true
        System.out.println(iter.next()); // returns "bc"
        System.out.println(iter.hasNext()); // returns false
    }
}
