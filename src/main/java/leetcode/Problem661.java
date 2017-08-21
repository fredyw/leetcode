package leetcode;

/**
 * https://leetcode.com/problems/image-smoother/
 */
public class Problem661 {
    public int[][] imageSmoother(int[][] M) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem661 prob = new Problem661();
        // [[0, 0, 0],
        //  [0, 0, 0],
        //  [0, 0, 0]]
        System.out.println(prob.imageSmoother(new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        }));
    }
}
