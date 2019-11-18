package leetcode;

/**
 * https://leetcode.com/problems/encode-number/
 */
public class Problem1256 {
    public String encode(int num) {
        String answer = "";
        int n = 1;
        int i = 1;
        outer:
        while (true) {
            for (int j = 0; j < Math.pow(2, n) && i <= num; j++) {
                if (i == num) {
                    answer = Integer.toBinaryString(j);
                    int length = answer.length();
                    for (int k = 0; k < n - length; k++) {
                        answer = "0" + answer;
                    }
                    break outer;
                }
                i++;
            }
            n++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1256 prob = new Problem1256();
        System.out.println(prob.encode(4)); // "01"
        System.out.println(prob.encode(8)); // "001"
        System.out.println(prob.encode(23)); // "1000"
        System.out.println(prob.encode(107)); // "101100"
        System.out.println(prob.encode(1000000000)); // "11011100110101100101000000001"
    }
}
