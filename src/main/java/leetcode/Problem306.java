package leetcode;

/**
 * https://leetcode.com/problems/additive-number/
 */
public class Problem306 {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            boolean result = isAdditiveNumber(num, i + 1);
            if (result) {
                return true;
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, int idx) {
        long a = Long.parseLong(num.substring(0, idx));
        int beg = idx;
        for (int i = 1; i < num.length(); i++) {
            int endIdx = idx + i;
            while (endIdx <= num.length()) {
                long b = Long.parseLong(num.substring(beg, endIdx));
//                System.out.println("a=" + a + ", b=" + b + ", end=" + end);
                boolean result = isAdditiveNumber(num, a, b, endIdx);
                if (result) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    private boolean isAdditiveNumber(String num, long a, long b, int idx) {
//        System.out.println("trying: a=" + a + ", b=" + b + ", idx=" + idx);
        long x = a;
        long y = b;
        long sum = x + y;
        String sumStr = Long.toString(sum);
        int begIdx = idx;
        int endIdx = begIdx + sumStr.length();
        if (endIdx > num.length()) {
            return false;
        }
        String nextStr = num.substring(begIdx, endIdx);
        if (!sumStr.equals(nextStr)) {
            return false;
        }
        while (endIdx < num.length()) {
            x = y;
            y = sum;
            sum = x + y;
            begIdx = endIdx;
            endIdx = begIdx + sumStr.length();
            if (endIdx > num.length()) {
                return false;
            }
            sumStr = Long.toString(sum);
            nextStr = num.substring(begIdx, endIdx);
            if (!sumStr.equals(nextStr)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem306 prob = new Problem306();
        // 1 1 2 3 5 8
//        System.out.println(prob.isAdditiveNumber("112358")); // true
//        System.out.println(prob.isAdditiveNumber("112358", 1, 1, 2));
        // 1 99 100 199
//        System.out.println(prob.isAdditiveNumber("199100199")); // true
//        System.out.println(prob.isAdditiveNumber("199100199", 1, 99, 3)); // true
        // 11 3 14 17 31
//        System.out.println(prob.isAdditiveNumber("113141731")); // true
//        System.out.println(prob.isAdditiveNumber("113141731", 11, 3, 3)); // true
        // 113 14 127 141
//        System.out.println(prob.isAdditiveNumber("11314127141")); // true
//        System.out.println(prob.isAdditiveNumber("11314127141", 113, 14, 5)); // true
        // 1980 1982 3962
//        System.out.println(prob.isAdditiveNumber("198019823962")); // true
    }
}
