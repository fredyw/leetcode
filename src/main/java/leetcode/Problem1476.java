package leetcode;

/**
 * https://leetcode.com/problems/subrectangle-queries/
 */
public class Problem1476 {
    static class SubrectangleQueries {
        public SubrectangleQueries(int[][] rectangle) {
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            // TODO
        }

        public int getValue(int row, int col) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1,2,1},{4,3,4},{3,2,1},{1,1,1}});
        // The initial rectangle (4x3) looks like:
        // 1 2 1
        // 4 3 4
        // 3 2 1
        // 1 1 1
        subrectangleQueries.getValue(0, 2); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        // After this update the rectangle looks like:
        // 5 5 5
        // 5 5 5
        // 5 5 5
        // 5 5 5
        subrectangleQueries.getValue(0, 2); // return 5
        subrectangleQueries.getValue(3, 1); // return 5
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
        // After this update the rectangle looks like:
        // 5   5   5
        // 5   5   5
        // 5   5   5
        // 10  10  10
        subrectangleQueries.getValue(3, 1); // return 10
        subrectangleQueries.getValue(0, 2); // return 5

        subrectangleQueries = new SubrectangleQueries(new int[][]{{1,1,1},{2,2,2},{3,3,3}});
        subrectangleQueries.getValue(0, 0); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
        subrectangleQueries.getValue(0, 0); // return 100
        subrectangleQueries.getValue(2, 2); // return 100
        subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
        subrectangleQueries.getValue(2, 2); // return 20
    }
}
