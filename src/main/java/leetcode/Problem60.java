package leetcode;

/**
 * https://leetcode.com/problems/permutation-sequence/
 */
public class Problem60 {
    public String getPermutation(int n, int k) {
        getPermutation(n, "");
        return "";
    }
    
    public void getPermutation(int n, String accu) {
        if (n == 0) {
            System.out.println(accu);
            return;
        }
        for (int i = 1; i <= n; i++) {
            getPermutation(n-1, accu + i);
        }
    }
    
    public static void main(String[] args) {
        Problem60 prob = new Problem60();
        System.out.println(prob.getPermutation(3, 6));
    }
}
