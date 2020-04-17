package leetcode;

/**
 * https://leetcode.com/problems/html-entity-parser/
 */
public class Problem1410 {
    public String entityParser(String text) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1410 prob = new Problem1410();
        System.out.println(prob.entityParser("&amp; is an HTML entity but &ambassador; is not.")); // "& is an HTML entity but &ambassador; is not."
        System.out.println(prob.entityParser("and I quote: &quot;...&quot;")); // "and I quote: \"...\""
        System.out.println(prob.entityParser("Stay home! Practice on Leetcode :)")); // "Stay home! Practice on Leetcode :)"
        System.out.println(prob.entityParser("x &gt; y &amp;&amp; x &lt; y is always false")); // "x > y && x < y is always false"
        System.out.println(prob.entityParser("leetcode.com&frasl;problemset&frasl;all")); // "leetcode.com/problemset/all"
    }
}
