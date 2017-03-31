package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/mini-parser/
 */
public class Problem385 {
    public static class NestedInteger {
        private Integer value;
        private final List<NestedInteger> nested = new ArrayList<>();

        // Constructor initializes an empty nested list.
        public NestedInteger() {
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return value != null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return isInteger() ? value : null;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            nested.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return isInteger() ? null : nested;
        }

        @Override
        public String toString() {
            return isInteger() ? Integer.toString(value) : nested.toString();
        }
    }

    private static class Token {
        private final String string;
        private int idx;

        public Token(String s) {
            this.string = s;
        }

        private boolean end() {
            return idx == string.length();
        }

        public char peek() {
            return string.charAt(idx);
        }

        public char next() {
            return string.charAt(idx++);
        }
    }

    public NestedInteger deserialize(String s) {
        return deserialize(new Token(s));
    }

    private static NestedInteger deserialize(Token token) {
        NestedInteger ni = new NestedInteger();
        while (!token.end()) {
            char c = token.peek();
            if (isNumber(c)) {
                Integer number = parseNumber(token);
                ni.add(new NestedInteger(number));
            } else if (c == '[') {
                token.next();
                ni.add(deserialize(token));
            } else if (c == ',') {
                token.next();
            } else if (c == ']') {
                token.next();
                break;
            }
        }
        return ni;
    }

    private static boolean isNumber(char c) {
        return c == '-' || (c >= '0' && c <= '9');
    }

    private static Integer parseNumber(Token token) {
        StringBuilder sb = new StringBuilder();
        while (!token.end() && isNumber(token.peek())) {
            sb.append(token.next());
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        Problem385 prob = new Problem385();

        System.out.println(prob.deserialize("324").getList());
        System.out.println(prob.deserialize("[123,324]").getList());
        System.out.println(prob.deserialize("[123,[456,[789]]]").getList());
        System.out.println(prob.deserialize("[123,345,[67,8,[9,10]],11]").getList());
    }
}
