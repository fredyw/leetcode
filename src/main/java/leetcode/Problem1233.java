package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
 */
public class Problem1233 {
    public List<String> removeSubfolders(String[] folder) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1233 prob = new Problem1233();
        System.out.println(prob.removeSubfolders(
            new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"})); // ["/a","/c/d","/c/f"]
        System.out.println(prob.removeSubfolders(
            new String[]{"/a","/a/b/c","/a/b/d"})); // ["/a""]
        System.out.println(prob.removeSubfolders(
            new String[]{"/a/b/c","/a/b/ca","/a/b/d"})); // ["/a/b/c","/a/b/ca","/a/b/d"]
    }
}
