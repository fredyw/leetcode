package leetcode;

/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 */
public class Problem959 {
    public int regionsBySlashes(String[] grid) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem959 prob = new Problem959();
        System.out.println(prob.regionsBySlashes(new String[]{
            " /",
            "/ "
        })); // 2
        System.out.println(prob.regionsBySlashes(new String[]{
            " /",
            "  "
        })); // 1
        System.out.println(prob.regionsBySlashes(new String[]{
            "\\/",
            "/\\"
        })); // 4
        System.out.println(prob.regionsBySlashes(new String[]{
            "/\\",
            "\\/"
        })); // 5
        System.out.println(prob.regionsBySlashes(new String[]{
            "//",
            "/ "
        })); // 3
    }
}
