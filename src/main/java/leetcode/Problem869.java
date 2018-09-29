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
        return reorderedPowerOf2(s, 0);
    }

    private static boolean reorderedPowerOf2(String s, int idx) {
        if (idx >= s.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i == idx) {
                continue;
            }
            String newString = newString(s, i);
            if (newString.startsWith("0")) {
                continue;
            }
            int n = Integer.parseInt(newString);
            if (isPower2(n)) {
                return true;
            }
            System.out.println(newString);
        }
        return reorderedPowerOf2(s, idx + 1);
    }

    private static String newString(String s, int i) {
        String left = (i - 1 >= 0) ? s.substring(0, i) : "";
        String right = (i + 1 < s.length()) ? s.substring(i + 1) : "";
        return s.charAt(i) + left + right;
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
//        System.out.println(prob.reorderedPowerOf2(562)); // true
//        System.out.println(prob.reorderedPowerOf2(821)); // false
        System.out.println(prob.reorderedPowerOf2(152)); // true
//        System.out.println(prob.reorderedPowerOf2(512)); // true
    }
}
