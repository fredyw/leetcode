package leetcode;

/**
 * https://leetcode.com/problems/quad-tree-intersection/
 */
public class Problem558 {
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
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem558 prob = new Problem558();
    }
}
