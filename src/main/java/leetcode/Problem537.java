package leetcode;

/**
 * https://leetcode.com/problems/complex-number-multiplication/
 */
public class Problem537  {
    public String complexNumberMultiply(String a, String b) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem537 prob = new Problem537();
        System.out.println(prob.complexNumberMultiply("1+1i", "1+1i")); // "0+2i"
        System.out.println(prob.complexNumberMultiply("1+-1i", "1+-1i")); // "0+-2i"
    }
}
