package leetcode;

/**
 * https://leetcode.com/problems/push-dominoes/
 */
public class Problem838 {
    public String pushDominoes(String dominoes) {
        char[] chars = new char[dominoes.length()];
        int cur = 0;
        int prev = 0;
        while (cur < dominoes.length()) {
            chars[cur] = dominoes.charAt(cur);
            if (dominoes.charAt(cur) == 'L') {
                if (dominoes.charAt(prev) == 'R') {
                    int mid = (prev + cur) / 2;
                    int mod = (prev + cur) % 2;
                    if (mod > 0) {
                        for (int i = prev; i <= mid; i++) {
                            chars[i] = 'R';
                        }
                        for (int i = mid + 1; i <= cur; i++) {
                            chars[i] = 'L';
                        }
                    } else {
                        for (int i = prev; i < mid; i++) {
                            chars[i] = 'R';
                        }
                        for (int i = mid + 1; i <= cur; i++) {
                            chars[i] = 'L';
                        }
                    }
                } else {
                    for (int i = prev; i <= cur; i++) {
                        chars[i] = 'L';
                    }
                }
                prev = cur;
            } else if (dominoes.charAt(cur) == 'R') {
                prev = cur;
                // TODO
            }
            cur++;
        }
        if (dominoes.charAt(prev) == 'R') {
            for (int i = prev; i < dominoes.length(); i++) {
                chars[i] = 'R';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Problem838 prob = new Problem838();
//        System.out.println(prob.pushDominoes(".L.R...LR..L..")); // LL.RR.LLRRLL..
//        System.out.println(prob.pushDominoes("R..L")); // RRLL
//        System.out.println(prob.pushDominoes("R...L")); // RR.LL
//        System.out.println(prob.pushDominoes("RR.L")); // RR.L
//        System.out.println(prob.pushDominoes("R..L")); // RRLL
//        System.out.println(prob.pushDominoes("R.LL")); // R.LL
//        System.out.println(prob.pushDominoes("...")); // ...
//        System.out.println(prob.pushDominoes("L..")); // L..
//        System.out.println(prob.pushDominoes("..L")); // LLL
//        System.out.println(prob.pushDominoes("..R")); // ..R
//        System.out.println(prob.pushDominoes("R..")); // RRR
//        System.out.println(prob.pushDominoes("..R..")); // ..RRR
//        System.out.println(prob.pushDominoes("..L..")); // LLL..
//        System.out.println(prob.pushDominoes("LLL")); // LLL
//        System.out.println(prob.pushDominoes("RRR")); // RRR
//        System.out.println(prob.pushDominoes("LR")); // LR
//        System.out.println(prob.pushDominoes("RL")); // LR
//        System.out.println(prob.pushDominoes("R.R.L")); // RRR.L
        System.out.println(prob.pushDominoes("R.R")); // RRR
    }
}
