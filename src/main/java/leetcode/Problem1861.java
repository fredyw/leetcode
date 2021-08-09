package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotating-the-box/
 */
public class Problem1861 {
    public char[][] rotateTheBox(char[][] box) {
        // TODO
        return null;
    }

    private static void print(char[][] chars) {
        for (char[] c : chars) {
            System.out.println(Arrays.toString(c));
        }
    }

    public static void main(String[] args) {
        Problem1861 prob = new Problem1861();
        // [["."],
        //  ["#"],`
        //  ["#"]]
        print(prob.rotateTheBox(new char[][]{
            {'#','.','#'}
        }));
        // [["#","."],
        //  ["#","#"],
        //  ["*","*"],
        //  [".","."]]
        print(prob.rotateTheBox(new char[][]{
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        }));
        // [[".","#","#"],
        //  [".","#","#"],
        //  ["#","#","*"],
        //  ["#","*","."],
        //  ["#",".","*"],
        //  ["#",".","."]]
        print(prob.rotateTheBox(new char[][]{
            {'#', '#', '*', '.', '*', '.'},
            {'#', '#', '#', '*', '.', '.'},
            {'#', '#', '#', '.', '#', '.'}
        }));
    }
}
