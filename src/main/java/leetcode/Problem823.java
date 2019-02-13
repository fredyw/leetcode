package leetcode;

/**
 * https://leetcode.com/problems/binary-trees-with-factors/
 */
public class Problem823 {
    public int numFactoredBinaryTrees(int[] A) {
        boolean[] set = new boolean[1001];;
        for (int a : A) {
            set[a] = true;;
        }
        int answer = 0;
        for (int i = 0; i < set.length; i++) {
            if (!set[i]) {
                continue;
            }
            answer += numFactoredBinaryTrees(set, i) + 1;
        }
        return answer;
    }

    private static int numFactoredBinaryTrees(boolean[] set, int root) {
        int count = 0;
        set[root] = false;;
        for (int i = 0; i < set.length; i++) {
            if (!set[i]) {
                continue;
            }
            if (root % i == 0) {
                int j = root / i;
                if (set[j]) {
                    count++;

                    set[i] = false;
                    count += numFactoredBinaryTrees(set, i);
                    set[i] = true;

                    set[j] = false;
                    count += numFactoredBinaryTrees(set, j);
                    set[j] = true;
                }
            }
        }
        set[root] = true;
        return count;
    }

    public static void main(String[] args) {
        Problem823 prob = new Problem823();
        System.out.println(prob.numFactoredBinaryTrees(new int[]{2, 4})); // 3
        System.out.println(prob.numFactoredBinaryTrees(new int[]{2, 4, 5, 10})); // 7
    }
}
