package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/
 */
public class Problem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem609 prob = new Problem609();
        // ["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]
        System.out.println(prob.findDuplicate(new String[]{
            "root/a 1.txt(abcd) 2.txt(efgh)",
            "root/c 3.txt(abcd)",
            "root/c/d 4.txt(efgh)",
            "root 4.txt(efgh)"}));
    }
}
