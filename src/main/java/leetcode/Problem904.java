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
                int count = 0;
                int type = tree[i - 1];
                int j = i - 1;
                while (j >= 0 && tree[j] == type) {
                    count++;
                    j--;
                }
                tc[0] = new TypeCount(tree[i - 1]);
                tc[0].count = count;
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
}
