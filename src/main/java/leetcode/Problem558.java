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
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            return new Node(false, true, topLeft, topRight, bottomLeft, bottomRight);
        } else if (!quadTree1.isLeaf) {
            boolean val = quadTree1.topLeft.val | quadTree1.topRight.val |
                quadTree1.bottomLeft.val | quadTree1.bottomRight.val;
            return new Node(val | quadTree2.val, false, null, null, null, null);
        }
        boolean val = quadTree2.topLeft.val | quadTree2.topRight.val |
            quadTree2.bottomLeft.val | quadTree2.bottomRight.val;
        return new Node(quadTree1.val | val, false, null, null, null, null);
    }

    public static void main(String[] args) {
        Problem558 prob = new Problem558();
    }
}
