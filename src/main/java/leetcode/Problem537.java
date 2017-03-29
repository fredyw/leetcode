package leetcode;

/**
 * https://leetcode.com/problems/complex-number-multiplication/
 */
public class Problem537  {
    public String complexNumberMultiply(String a, String b) {
        String[] aSplit = a.split("\\+");
        int ar = Integer.parseInt(aSplit[0]);
        int ai = Integer.parseInt(aSplit[1].substring(0, aSplit[1].length() - 1));

        String[] bSplit = b.split("\\+");
        int br = Integer.parseInt(bSplit[0]);
        int bi = Integer.parseInt(bSplit[1].substring(0, bSplit[1].length() - 1));

        return ((ar * br) + (ai * bi * -1)) + "+" + ((ar * bi) + (br * ai)) + "i";
    }
}
