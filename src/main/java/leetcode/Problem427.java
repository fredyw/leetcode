package leetcode;

/**
 * https://leetcode.com/problems/construct-quad-tree/
 */
public class Problem427 {
    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val,
                    boolean _isLeaf,
                    Node _topLeft,
                    Node _topRight,
                    Node _bottomLeft,
                    Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }

        @Override
        public String toString() {
            return "Node{" +
                "val=" + val +
                ", isLeaf=" + isLeaf +
                ", topLeft=" + topLeft +
                ", topRight=" + topRight +
                ", bottomLeft=" + bottomLeft +
                ", bottomRight=" + bottomRight +
                '}';
        }
    }

    public Node construct(int[][] grid) {
        if (grid.length == 0) {
            return null;
        }
        return construct(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    private static Node construct(int[][] grid, int x1, int y1, int x2, int y2) {
//        System.out.println(String.format("(%s, %s), (%s, %s)", x1, y1, x2, y2));
        if (x1 > x2 || y1 > y2) {
            return null;
        }
        int val = -1;
        boolean allSame = true;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (val == -1) {
                    val = grid[i][j];
                } else {
                    if (grid[i][j] != val) {
                        allSame = false;
                        break;
                    }
                }
            }
        }
        if (allSame) {
            return new Node(val == 0 ? false : true, true, null, null, null, null);
        }
        int nRow = x2 - x1;
        int nCol = y2 - y1;
        int r = (nRow + 1) / 2;
        int c = (nCol + 1) / 2;
//        System.out.println(r + ", " + c);
//        System.out.println(String.format("top left: (%s, %s), (%s, %s)", x1, y1, x1 + r - 1, y1 + c - 1));
//        System.out.println(String.format("top right: (%s, %s), (%s, %s)", x1, y1 + c, x1 + r - 1, y2));
//        System.out.println(String.format("bottom left: (%s, %s), (%s, %s)", x1 + r, y1, x2, y1 + c - 1));
//        System.out.println(String.format("bottom right: (%s, %s), (%s, %s)", x1 + r, y1 + c, x2, y2));
//        return null;
        Node topLeft = construct(grid, x1, y1, x1 + r - 1, y1 + c - 1);
        Node topRight = construct(grid, x1, y1 + c, x1 + r - 1, y2);
        Node bottomLeft = construct(grid, x1 + r, y1, x2, y1 + c - 1);
        Node bottomRight = construct(grid, x1 + r, y1 + c, x2, y2);
        if (topLeft != null && topRight != null && bottomLeft != null && bottomRight != null) {
            if (topLeft.val == topRight.val &&
                topLeft.val == bottomLeft.val &&
                topLeft.val == bottomRight.val) {
                return new Node(topLeft.val, true, null, null, null, null);
            }
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static void main(String[] args) {
        Problem427 prob = new Problem427();
        Node root = prob.construct(new int[][]{
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 0, 1, 1},
            {0, 1, 1, 1}
        });
        System.out.println(root.topLeft);
        System.out.println(root.topRight);
        System.out.println(root.bottomLeft);
        System.out.println(root.bottomRight);

        // {"$id":"1","bottomLeft":{"$id":"8","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"bottomRight":{"$id":"9","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"isLeaf":false,"topLeft":{"$id":"2","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"topRight":{"$id":"3","bottomLeft":{"$id":"6","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"bottomRight":{"$id":"7","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"isLeaf":false,"topLeft":{"$id":"4","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"topRight":{"$id":"5","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"val":false},"val":false}
        // {"$id":"1","bottomLeft":{"$id":"8","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"bottomRight":{"$id":"9","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"isLeaf":false,"topLeft":{"$id":"2","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"topRight":{"$id":"3","bottomLeft":{"$id":"6","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"bottomRight":{"$id":"7","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"isLeaf":false,"topLeft":{"$id":"4","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"topRight":{"$id":"5","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"val":true},"val":true}
    }
}
