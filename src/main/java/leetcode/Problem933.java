package leetcode;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class Problem933 {
    private static class RecentCounter {

        public RecentCounter() {

        }

        public int ping(int t) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1)); // 1
        System.out.println(counter.ping(100)); // 2
        System.out.println(counter.ping(3001)); // 3
        System.out.println(counter.ping(3002)); // 3
        System.out.println(counter.ping(3003)); // 4
        System.out.println(counter.ping(6004)); // 1
    }
}
