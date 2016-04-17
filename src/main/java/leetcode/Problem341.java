package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/
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
        private final Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> list = new ArrayList<>();
            populateIntegerList(nestedList, list);
            iterator = list.iterator();
        }

        private void populateIntegerList(List<NestedInteger> nestedList, List<Integer> list) {
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    list.add(ni.getInteger());
                } else {
                    populateIntegerList(ni.getList(), list);
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
