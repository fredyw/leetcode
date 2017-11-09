package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/remove-comments/
 */
public class Problem722 {
    public List<String> removeComments(String[] source) {
        return null;
    }

    public static void main(String[] args) {
        Problem722 prob = new Problem722();
        System.out.println(prob.removeComments(new String[]{
            "/*Test program */",
            "int main()", "{ ",
            "  // variable declaration ",
            "int a, b, c;",
            "/* This is a test",
            "   multiline  ",
            "   comment for ",
            "   testing */",
            "a = b + c;", "}"})); // ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
        System.out.println(prob.removeComments(new String[]{"a/*comment", "line", "more_comment*/b"})); // [ab]
    }
}
