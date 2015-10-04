package leetcode;

import java.util.Iterator;

/**
 * https://leetcode.com/problems/peeking-iterator/
 */
public class Problem284 {
    private static class PeekingIterator implements Iterator<Integer> {
        private final Iterator<Integer> iterator;
        private Integer peek;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            if (iterator.hasNext()) {
                peek = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer oldPeek = peek;
            if (iterator.hasNext()) {
                peek = iterator.next();
            } else {
                peek = null;
            }
            return oldPeek;
        }

        @Override
        public boolean hasNext() {
            if (peek == null) {
                return false;
            }
            return true;
        }
    }
}
