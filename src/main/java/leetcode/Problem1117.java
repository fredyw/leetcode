package leetcode;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/building-h2o/
 */
public class Problem1117 {
    private static class H2O {
        private final Semaphore hSemaphore = new Semaphore(2);
        private final Semaphore oSempahore = new Semaphore(0);

        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            hSemaphore.acquire();
            releaseHydrogen.run();
            oSempahore.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            oSempahore.acquire(2);
            releaseOxygen.run();
            hSemaphore.release(2);
        }
    }
}
