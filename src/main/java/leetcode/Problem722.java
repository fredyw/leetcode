package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-comments/
 */
public class Problem722 {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean skip = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length; i++) {
            String src = source[i];
            int j = 0;
            outer:
            for (; j < src.length(); j++) {
                if (j + 1 < src.length() && src.charAt(j) == '/') {
                    if (!skip && src.charAt(j + 1) == '/') {
                        skip = false;
                        break outer;
                    } else if (!skip && src.charAt(j + 1) == '*') {
                        skip = true;
                        j++;
                    }
                } else if (j + 1 < src.length() && src.charAt(j) == '*') {
                    if (skip && src.charAt(j + 1) == '/') {
                        skip = false;
                        j += 2;
                    }
                }
                if (!skip && j < src.length()) {
                    sb.append(src.charAt(j));
                }
            }
            if (sb.length() > 0 && !skip) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem722 prob = new Problem722();
        System.out.println(prob.removeComments(new String[]{
            "/*Test program */",
            "int main()",
            "{ ",
            "  // variable declaration ",
            "int a, b, c;",
            "/* This is a test",
            "   multiline  ",
            "   comment for ",
            "   testing */",
            "a = b + c;",
            "}"})); // ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
        System.out.println(prob.removeComments(new String[]{
            "a/*comment",
            "line",
            "more_comment*/b"})); // [ab]
        System.out.println(prob.removeComments(new String[]{
            "a/b/*comment*/c+d/*",
            "line",
            "more_comment*/b"})); // [a/bc+db]
        System.out.println(prob.removeComments(new String[]{
            "void func(int k) {",
            "// this function does nothing /*",
            "   k = k*2/4;",
            "   k = k/2;*/", "}"
        })); // ["void func(int k) {","   k = k*2/4;","   k = k/2;*/","}"]
        System.out.println(prob.removeComments(new String[]{
            "a//*b/*/c",
            "blank",
            "d/*/e/*/f"
        })); // ["a","blank","df"]
        System.out.println(prob.removeComments(new String[]{
            "a/*/b//*c",
            "blank",
            "d//*e/*/f"
        })); // ["af"]
    }
}
