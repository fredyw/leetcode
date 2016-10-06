package leetcode;

/**
 * https://leetcode.com/problems/utf-8-validation/
 */
public class Problem393 {
    public boolean validUtf8(int[] data) {
        int i = 0;
        int count = 0;
        while (i < data.length) {
            int d = data[i];
            if (count > 0) {
                if ((d & 0b10000000) == 0b10000000) {
                    count--;
                } else {
                    return false;
                }
            } else {
                if ((d & 0b11110000) == 0b11110000) { // 4 bytes
                    count = 3;
                } else if ((d & 0b11100000) == 0b11100000) { // 3 bytes
                    count = 2;
                } else if ((d & 0b11000000) == 0b11000000) { // 2 bytes
                    count = 1;
                } else { // 1 byte
                    if (d > 0b1111111) {
                        return false;
                    }
                    count = 0;
                }
            }
            i++;
        }
        if (count > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem393 prob = new Problem393();
        System.out.println(prob.validUtf8(new int[]{197, 130, 1})); // true
        System.out.println(prob.validUtf8(new int[]{235, 140, 4})); // false
        System.out.println(prob.validUtf8(new int[]{127})); // true
        System.out.println(prob.validUtf8(new int[]{255})); // false
        System.out.println(prob.validUtf8(new int[]{145})); // false
    }
}
