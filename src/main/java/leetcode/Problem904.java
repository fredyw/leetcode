package leetcode;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class Problem904 {
    public int totalFruit(int[] tree) {
        int answer = 0;
        TypeCount[] tc = new TypeCount[2];
        for (int i = 0; i < tree.length; i++) {
            if (tc[0] == null) {
                tc[0] = new TypeCount(tree[i]);
                tc[0].count++;
            } else if (tree[i] == tc[0].type) {
                tc[0].count++;
            } else if (tc[1] == null) {
                tc[1] = new TypeCount(tree[i]);
                tc[1].count++;
            } else if (tree[i] == tc[1].type) {
                tc[1].count++;
            } else {
                tc[0] = tc[1];
                tc[1] = new TypeCount(tree[i]);
                tc[1].count++;
            }
            answer = Math.max(answer, (tc[0] == null ? 0 : tc[0].count) +
                (tc[1] == null ? 0 : tc[1].count));
        }
        return answer;
    }

    private static class TypeCount {
        private final int type;
        private int count;

        public TypeCount(int num) {
            this.type = num;
        }
    }

    public static void main(String[] args) {
        Problem904 prob = new Problem904();
//        System.out.println(prob.totalFruit(new int[]{1, 2, 1})); // 3
//        System.out.println(prob.totalFruit(new int[]{0, 1, 2, 2})); // 3
//        System.out.println(prob.totalFruit(new int[]{1, 2, 3, 2, 2})); // 4
//        System.out.println(prob.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4})); // 5
        System.out.println(prob.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3})); // 5
    }
}
