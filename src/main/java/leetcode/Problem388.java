package leetcode;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class Problem388 {
    public int lengthLongestPath(String input) {
        // TODO:
        return 0;
    }

    public static void main(String[] args) {
        Problem388 prob = new Problem388();
        System.out.println(prob.lengthLongestPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext")); // 32
    }
}
