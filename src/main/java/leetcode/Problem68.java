package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/text-justification/
 */
public class Problem68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int width = 0;
        int originalWidth = 0;
        int beg = 0;
        int end = 0;
        while (end < words.length) {
            originalWidth += words[end].length();
            width += words[end].length();
            if (width + 1 < maxWidth) { // for a space
                width++;
            }
            if (width >= maxWidth) {
                originalWidth -= words[end].length();
                String line = "";
                int diff = maxWidth - originalWidth;
                int sections = end - beg - 1;
                if (sections <= 0) {
//                    if (width == maxWidth) {
//                        end++;
//                    }
                    for (int i = beg; i < end; i++) {
                        line += words[i];
                        if (i < end - 1) {
                            line += " ";
                        }
                    }
                } else {
                    int spaces = diff / sections;
                    int spaceRemainder = diff % sections;
                    for (int i = beg; i < end; i++) {
                        line += words[i];
                        if (i < end - 1) {
                            for (int space = 0; space < spaces; space++) {
                                line += " ";
                            }
                            if (spaceRemainder > 0) {
                                line += " ";
                                spaceRemainder--;
                            }
                        }
                    }
                }
                if (!line.isEmpty()) {
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                    result.add(line);
                }
                width = words[end].length();
                originalWidth = words[end].length();
                beg = end;
            }
            end++;
        }
        String line = "";
        for (int i = beg; i < end; i++) {
            line += words[i];
            if (i < end - 1) {
                line += " ";
            }
        }
        while (line.length() < maxWidth) {
            line += " ";
        }
        result.add(line);
        return result;
    }

    public static void main(String[] args) {
        Problem68 prob = new Problem68();

//        // "This    is    an",
//        // "example  of text",
//        // "justification.  "
//        prob.fullJustify(new String[]{
//            "This", "is", "an", "example", "of", "text", "justification."}, 16).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
//        // "This     is    an",
//        // "example  of  text",
//        // "justification.   "
//        prob.fullJustify(new String[]{
//            "This", "is", "an", "example", "of", "text", "justification."}, 17).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
//        // "This    is    an",
//        // "example  of text",
//        // "hello world.    "
//        prob.fullJustify(new String[]{
//            "This", "is", "an", "example", "of", "text", "hello", "world."}, 16).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
        // "Hello world."
        prob.fullJustify(new String[]{
            "Hello", "world."}, 12).forEach(e -> System.out.println("|" + e + "|"));
        System.out.println();
//
//        // "Hello "
//        // "world "
//        prob.fullJustify(new String[]{
//            "Hello", "world"}, 6).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
//        // "Hello world.   "
//        prob.fullJustify(new String[]{
//            "Hello", "world."}, 16).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
//        // "Hello"
//        prob.fullJustify(new String[]{
//            "Hello"}, 5).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
//        // "Hello   "
//        prob.fullJustify(new String[]{
//            "Hello"}, 8).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
//        // "This     is    an",
//        // "example  of  text",
//        // "justification123."
//        prob.fullJustify(new String[]{
//            "This", "is", "an", "example", "of", "text", "justification123."}, 17).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();
//
//        // "12345",
//        // "12345",
//        // "12345"
//        prob.fullJustify(new String[]{
//            "12345", "12345", "12345"}, 5).forEach(e -> System.out.println("|" + e + "|"));
//        System.out.println();

        // "a b"
        // "c d"
        // "e  "
        prob.fullJustify(new String[]{
            "a","b","c","d","e"}, 3).forEach(e -> System.out.println("|" + e + "|"));
    }
}
