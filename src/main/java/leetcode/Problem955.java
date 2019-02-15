package leetcode;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class Problem955 {
    public int minDeletionSize(String[] A) {
        int n = A[0].length();
        char[][] chars = new char[A.length][];
        for (int i = 0; i < A.length; i++) {
            chars[i] = A[i].toCharArray();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            char[] prev = null;
            boolean remove = false;
            for (int j = 0; j < chars.length; j++) {
                if (j == 0) {
                    prev = chars[j];
                } else {
                    if (new String(prev).compareTo(new String(chars[j])) > 0) {
                        remove = true;
                        break;
                    }
                }
            }
            if (remove) {
                answer++;
                for (int j = 0; j < chars.length; j++) {
                    chars[j][i] = ' ';
                }
            }
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.println(new String(chars[i]));
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem955 prob = new Problem955();
//        System.out.println(prob.minDeletionSize(new String[]{"ca", "bb", "ac"})); // 1
//        System.out.println(prob.minDeletionSize(new String[]{"xc", "yb", "za"})); // 0
//        System.out.println(prob.minDeletionSize(new String[]{"zyx","wvu","tsr"})); // 3
//        System.out.println(prob.minDeletionSize(new String[]{"abcdef", "uvwxyz"})); // 0
        System.out.println(prob.minDeletionSize(new String[]{"xga", "xfb", "yfa"})); // 1
    }
}
