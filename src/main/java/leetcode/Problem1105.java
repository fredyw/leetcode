package leetcode;

/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 */
public class Problem1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        return minHeightShelves(books, shelf_width, 0, 0, 0, new Integer[books.length][shelf_width + 1]);
    }

    private static int minHeightShelves(int[][] books, int shelfWidth,
                                        int totalWidth, int maxHeight, int index,
                                        Integer[][] memo) {
        if (index == books.length) {
            return maxHeight;
        }
        if (memo[index][totalWidth] != null) {
            return memo[index][totalWidth];
        }
        int width = books[index][0];
        int height = books[index][1];
        int answer;
        if (totalWidth + width <= shelfWidth) {
            int a = minHeightShelves(books, shelfWidth, totalWidth + width,
                Math.max(maxHeight, height), index + 1, memo);
            int b = minHeightShelves(books, shelfWidth, width, height, index + 1, memo) + maxHeight;
            answer = Math.min(a, b);
        } else {
            answer = minHeightShelves(books, shelfWidth, width, height, index + 1, memo) + maxHeight;
        }
        memo[index][totalWidth] = answer;
        return answer;
    }
}
