package leetcode;

/**
 * https://leetcode.com/problems/rotating-the-box/
 */
public class Problem1861 {
    public char[][] rotateTheBox(char[][] box) {
        int maxRow = box.length;
        int maxCol = box.length > 0 ? box[0].length : 0;
        char[][] answer = new char[maxCol][maxRow];
        for (int col = 0; col < maxCol; col++) {
            for (int row = 0; row < maxRow; row++) {
                answer[col][maxRow - row - 1] = box[row][col];
            }
        }
        maxRow = answer.length;
        maxCol = answer.length > 0 ? answer[0].length : 0;
        for (int col = 0; col < maxCol; col++) {
            for (int row = maxRow - 1; row >= 0; row--) {
                if (answer[row][col] == '#') {
                    int r = row;
                    while (r + 1 < maxRow && answer[r + 1][col] == '.') {
                        char tmp = answer[r][col];
                        answer[r][col] = answer[r + 1][col];
                        answer[r + 1][col] = tmp;
                        r++;
                    }
                }
            }
        }
        return answer;
    }
}
