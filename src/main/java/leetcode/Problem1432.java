package leetcode;

/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 */
public class Problem1432 {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        int i = 0;
        while (i < s.length() && s.charAt(i) == '9') {
            i++;
        }
        StringBuilder max = new StringBuilder();
        if (i == s.length()) {
            i = 0;
        }
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                max.append("9");
            } else {
                max.append(s.charAt(j));
            }
        }
        StringBuilder min = new StringBuilder();
        i = 0;
        boolean zero = false;
        if (s.charAt(i) == '1') {
            while (i < s.length() && s.charAt(i) == '1') {
                i++;
            }
            if (i == s.length()) {
                i = 0;
            } else {
                zero = true;
            }
        }

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                min.append(zero ? "0" : "1");
            } else {
                min.append(s.charAt(j));
            }
        }
        System.out.println(max + " " + min);
        return Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());
    }

    public static void main(String[] args) {
        Problem1432 prob = new Problem1432();
//        System.out.println(prob.maxDiff(555)); // 888
//        System.out.println(prob.maxDiff(9)); // 8
//        System.out.println(prob.maxDiff(123456)); // 820000
//        System.out.println(prob.maxDiff(10000)); // 80000
//        System.out.println(prob.maxDiff(9288)); // 8700
//        System.out.println(prob.maxDiff(9289)); // 8708
//        System.out.println(prob.maxDiff(1111)); // 8888
//        System.out.println(prob.maxDiff(9999)); // 8888
//        System.out.println(prob.maxDiff(1000)); // 8000
//        System.out.println(prob.maxDiff(3)); // 8
        System.out.println(prob.maxDiff(1101057)); // 8808050
    }
}
