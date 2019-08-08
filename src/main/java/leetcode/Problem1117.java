package leetcode;

/**
 * https://leetcode.com/problems/building-h2o/
 */
public class Problem1117 {
    private static class H2O {
        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        }
    }
}
