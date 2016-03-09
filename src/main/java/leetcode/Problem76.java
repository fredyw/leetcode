package leetcode;

import java.util.Objects;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Problem76 {
    public String minWindow(String s, String t) {
        TreeSet<Character> charSet = new TreeSet<>();
        for (char c : t.toCharArray()) {
            charSet.add(c);
        }
        TreeSet<CharIdx> charIdxSet = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charSet.contains(c)) {
                charIdxSet.add(new CharIdx(c, i));
            }
        }
        charIdxSet.forEach(System.out::println);
        int min = Integer.MAX_VALUE;
        for (CharIdx ci : charIdxSet) {

        }
        return "";
    }

    private static class CharIdx implements Comparable<CharIdx> {
        private final char character;
        private final int idx;

        public CharIdx(char character, int idx) {
            this.character = character;
            this.idx = idx;
        }

        @Override
        public int compareTo(CharIdx o) {
            return Integer.valueOf(idx).compareTo(Integer.valueOf(o.idx));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharIdx charIdx = (CharIdx) o;
            return character == charIdx.character;
        }

        @Override
        public int hashCode() {
            return Objects.hash(character);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("CharIdx{");
            sb.append("character=").append(character);
            sb.append(", idx=").append(idx);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class Foo {
        Foo doSomething(String a) {
            String b = a.substring(0);
            return this;
        }
    }

    public static void main(String[] args) {
        Problem76 prob = new Problem76();
        System.out.println(prob.minWindow("ADOBECODEBANC", "ABC")); // BANC
    }
}
