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
            return new Node(quadTree1.val | quadTree2.val, true, null, null, null, null);
        } else if (!quadTree1.isLeaf && quadTree2.isLeaf) {
            return quadTree2.val ? quadTree2 : quadTree1;
        } else if (quadTree1.isLeaf && !quadTree2.isLeaf) {
            return quadTree1.val ? quadTree1 : quadTree2;
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        if (topLeft.isLeaf && topRight.isLeaf &&
            bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val &&
            topLeft.val == bottomLeft.val &&
            topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
