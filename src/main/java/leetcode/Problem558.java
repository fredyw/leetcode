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

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val | quadTree2.val, true, null, null, null, null);
        } else if (!quadTree1.isLeaf && quadTree2.isLeaf) {
            boolean val = quadTree1.topLeft.val | quadTree1.topRight.val |
                quadTree1.bottomLeft.val | quadTree1.bottomRight.val;
            return new Node(val | quadTree2.val, true, null, null, null, null);
        } else if (quadTree1.isLeaf && !quadTree2.isLeaf) {
            boolean val = quadTree2.topLeft.val | quadTree2.topRight.val |
                quadTree2.bottomLeft.val | quadTree2.bottomRight.val;
            return new Node(quadTree1.val | val, true, null, null, null, null);
        }
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public static void main(String[] args) {
        Problem558 prob = new Problem558();

        Node tree1 = new Node(true, false,
            new Node(true, true, null, null, null, null),
            new Node(true, true, null, null, null, null),
            new Node(false, true, null, null, null, null),
            new Node(false, true, null, null, null, null));
        Node tree2 = new Node(true, false,
            new Node(true, true, null, null, null, null),
            new Node(true, false,
                new Node(false, true, null, null, null, null),
                new Node(false, true, null, null, null, null),
                new Node(true, true, null, null, null, null),
                new Node(true, true, null, null, null, null)),
            new Node(true, true, null, null, null, null),
            new Node(false, true, null, null, null, null));

        Node tree = prob.intersect(tree1, tree2);
        System.out.println(tree.topLeft); // true
        System.out.println(tree.topRight); // true
        System.out.println(tree.bottomLeft); // true
        System.out.println(tree.bottomRight); // false
    }
}
