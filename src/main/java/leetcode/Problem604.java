package leetcode;

/**
 * https://leetcode.com/problems/design-compressed-string-iterator/
 */
public class Problem604 {
    public static class StringIterator {

        public StringIterator(String compressedString) {

        }

        public char next() {
            // TODO
            return 0;
        }

        public boolean hasNext() {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        StringIterator iter = new StringIterator("L1e2t1C1o1d1e1");
        System.out.println(iter.next()); // L
        System.out.println(iter.next()); // e
        System.out.println(iter.next()); // e
        System.out.println(iter.next()); // t
        System.out.println(iter.next()); // C
        System.out.println(iter.next()); // o
        System.out.println(iter.next()); // d
        System.out.println(iter.hasNext()); // true
        System.out.println(iter.next()); // e
        System.out.println(iter.hasNext()); // false
        System.out.println(iter.next()); // ' '
    }
}
