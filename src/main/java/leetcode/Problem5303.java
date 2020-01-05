package leetcode;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */
public class Problem5303 {
    public String freqAlphabets(String s) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem5303 prob = new Problem5303();
        System.out.println(prob.freqAlphabets("10#11#12")); // "jkab"
        System.out.println(prob.freqAlphabets("1326#")); // "acz"
        System.out.println(prob.freqAlphabets("25#")); // "y"
        System.out.println(prob.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#")); // "abcdefghijklmnopqrstuvwxyz"
    }
}
