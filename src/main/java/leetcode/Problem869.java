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
        return reorderedPowerOf2(s.toCharArray(), 0);
    }

    private static boolean reorderedPowerOf2(char[] chars, int idx) {
        if (idx == chars.length) {
            String newString = new String(chars);
//            System.out.println(newString);
            if (newString.startsWith("0")) {
                return false;
            }
            int n = Integer.parseInt(newString);
            return isPower2(n);
        }
        for (int i = idx; i < chars.length; i++) {
            swap(chars, idx, i);
            if (reorderedPowerOf2(chars, idx + 1)) {
                return true;
            }
            // Backtrack.
            swap(chars, idx, i);
        }
        return false;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static double log2(int n) {
        return Math.log(n) / Math.log(2);
    }

    private static boolean isPower2(int n) {
        return (Math.ceil(log2(n)) == Math.floor(log2(n)));
    }

    public static void main(String[] args) {
        Problem869 prob = new Problem869();
//        System.out.println(prob.reorderedPowerOf2(1)); // true
//        System.out.println(prob.reorderedPowerOf2(10)); // false
//        System.out.println(prob.reorderedPowerOf2(16)); // true
//        System.out.println(prob.reorderedPowerOf2(24)); // false
//        System.out.println(prob.reorderedPowerOf2(46)); // true
//        System.out.println(prob.reorderedPowerOf2(562)); // true
//        System.out.println(prob.reorderedPowerOf2(821)); // true
//        System.out.println(prob.reorderedPowerOf2(128)); // true
//        System.out.println(prob.reorderedPowerOf2(152)); // true
//        System.out.println(prob.reorderedPowerOf2(512)); // true
        System.out.println(prob.reorderedPowerOf2(679213508)); // true
    }
}
