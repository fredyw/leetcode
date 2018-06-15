package leetcode;

/**
 * https://leetcode.com/problems/push-dominoes/
 */
public class Problem838 {
    public String pushDominoes(String dominoes) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem838 prob = new Problem838();
        System.out.println(prob.pushDominoes(".L.R...LR..L..")); // LL.RR.LLRRLL..
        System.out.println(prob.pushDominoes("RR.L")); // RR.L
        System.out.println(prob.pushDominoes("R..L")); // RRLL
        System.out.println(prob.pushDominoes("R.LL")); // R.LL
        System.out.println(prob.pushDominoes("...")); // ...
        System.out.println(prob.pushDominoes("L..")); // LLL
        System.out.println(prob.pushDominoes("..R")); // RRR
    }
}
