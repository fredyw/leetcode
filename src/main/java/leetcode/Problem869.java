package leetcode;

/**
 * https://leetcode.com/problems/reordered-power-of-2/
 */
public class Problem869 {
    public boolean reorderedPowerOf2(int N) {
        if (isPower2(N)) {
            return true;
        }
        String s = "" + N;
        char[] chars = s.toCharArray();
        return reorderedPowerOf2(chars, 0);
    }

    private static boolean reorderedPowerOf2(char[] chars, int idx) {
        if (idx >= chars.length) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i == idx) {
                continue;
            }
            swap(chars, idx, i);
            String newString = new String(chars);
            int n = Integer.parseInt(newString);

            System.out.println(newString);
            // Backtrack.
            swap(chars, idx, i);
        }
        return reorderedPowerOf2(chars, idx + 1);
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static boolean isPower2(int n) {
        double dsqrt = Math.sqrt(n);
        int isqrt = (int) dsqrt;
        return dsqrt - isqrt == 0;
    }

    public static void main(String[] args) {
        Problem869 prob = new Problem869();
//        System.out.println(prob.reorderedPowerOf2(1)); // true
//        System.out.println(prob.reorderedPowerOf2(10)); // false
//        System.out.println(prob.reorderedPowerOf2(16)); // true
//        System.out.println(prob.reorderedPowerOf2(24)); // false
//        System.out.println(prob.reorderedPowerOf2(46)); // true
        System.out.println(prob.reorderedPowerOf2(562)); // true
    }
}
