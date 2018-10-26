package leetcode;

/**
 * https://leetcode.com/problems/online-election/
 */
public class Problem911 {
    private static class TopVotedCandidate {
        public TopVotedCandidate(int[] persons, int[] times) {
        }

        public int q(int t) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        TopVotedCandidate candidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0},
            new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(candidate.q(3)); // 0
        System.out.println(candidate.q(12)); // 1
        System.out.println(candidate.q(25)); // 1
        System.out.println(candidate.q(15)); // 0
        System.out.println(candidate.q(24)); // 0
        System.out.println(candidate.q(8)); // 1
    }
}
