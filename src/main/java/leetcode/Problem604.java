package leetcode;

/**
 * https://leetcode.com/problems/design-compressed-string-iterator/
 */
public class Problem604 {
    public static class StringIterator {
        private final String compressedString;
        private int idx;
        private int count;
        private char ch;

        public StringIterator(String compressedString) {
            this.compressedString = compressedString;
        }

        public char next() {
            if (!hasNext()) {
                return  ' ';
            }
            if (count == 0) {
                ch = compressedString.charAt(idx);
                // get the number
                idx++;
                StringBuilder sb = new StringBuilder();
                char c = compressedString.charAt(idx);
                while (c >= '0' && c <= '9' && idx < compressedString.length()) {
                    sb.append(c);
                    idx++;
                    if (idx < compressedString.length()) {
                        c = compressedString.charAt(idx);
                    }
                }
                count = Integer.parseInt(sb.toString());
            }
            count--;
            return ch;
        }

        public boolean hasNext() {
            return !(count == 0 && idx >= compressedString.length());
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

        iter = new StringIterator("a10b11c1d5e12");
        while (iter.hasNext()) {
            System.out.print(iter.next());
        }
        System.out.println();
    }
}
