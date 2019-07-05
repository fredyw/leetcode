package leetcode;

/**
 * https://leetcode.com/problems/filling-bookcase-shelves/
 */
public class Problem1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        return minHeightShelves(books, shelf_width, 0, 0, 0);
    }

    private static int minHeightShelves(int[][] books, int shelfWidth,
                                        int totalWidth, int maxHeight, int index) {
        if (index == books.length) {
            return maxHeight;
        }
        int width = books[index][0];
        int height = books[index][1];
        if (totalWidth + width <= shelfWidth) {
            int a = minHeightShelves(books, shelfWidth, totalWidth + width,
                Math.max(maxHeight, height), index + 1);
            int b = minHeightShelves(books, shelfWidth, width, height, index + 1) + maxHeight;
            return Math.min(a, b);
        }
        return minHeightShelves(books, shelfWidth, width, height, index + 1) + maxHeight;
    }

    public static void main(String[] args) {
        Problem1105 prob = new Problem1105();
        System.out.println(prob.minHeightShelves(new int[][]{
            {1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}
        }, 4)); // 6
        System.out.println(prob.minHeightShelves(new int[][]{
            {1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}
        }, 8)); // 4
        System.out.println(prob.minHeightShelves(new int[][]{
            {1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}, {2, 4}, {3, 1}
        }, 4)); // 10
        System.out.println(prob.minHeightShelves(new int[][]{
            {1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}, {2, 4}, {3, 1}
        }, 7)); // 7
    }
}
