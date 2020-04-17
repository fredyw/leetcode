package leetcode;

/**
 * https://leetcode.com/problems/html-entity-parser/
 */
public class Problem1410 {
    public String entityParser(String text) {
        return text
            .replaceAll("&quot;", "\"")
            .replaceAll("&apos;", "'")
            .replaceAll("&gt;", ">")
            .replaceAll("&lt;", "<")
            .replaceAll("&frasl;", "/")
            .replaceAll("&amp;", "&");
    }
}
