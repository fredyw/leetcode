package leetcode;

import java.util.Iterator;
import java.util.List;

/**
 * @author fredy
 */
public class Problem341 {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public static class NestedIterator implements Iterator<Integer> {
        public NestedIterator(List<NestedInteger> nestedList) {
            // TODO
        }

        @Override
        public Integer next() {
            // TODO:
            return null;
        }

        @Override
        public boolean hasNext() {
            // TODO:
            return false;
        }
    }

    public static void main(String[] args) {
        NestedIterator i = new NestedIterator(null);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
