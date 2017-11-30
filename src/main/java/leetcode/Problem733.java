package leetcode;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class Problem733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int maxRow = image.length;
        int maxCol = 0;
        if (image.length > 0) {
            maxCol = image[0].length;
        }
        boolean[][] visited = new boolean[maxRow][maxCol];
        floodFill(image, sr, sc, newColor, image[sr][sc], maxRow, maxCol, visited);
        return image;
    }

    private static void floodFill(int[][] image, int row, int col, int newColor, int originalColor,
                                  int maxRow, int maxCol, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (image[row][col] == originalColor) {
            image[row][col] = newColor;
        } else {
            return;
        }
        // top
        floodFill(image, row - 1, col, newColor, originalColor, maxRow, maxCol, visited);
        // right
        floodFill(image, row, col + 1, newColor, originalColor, maxRow, maxCol, visited);
        // down
        floodFill(image, row + 1, col, newColor, originalColor, maxRow, maxCol, visited);
        // left
        floodFill(image, row, col - 1, newColor, originalColor, maxRow, maxCol, visited);
    }
}
