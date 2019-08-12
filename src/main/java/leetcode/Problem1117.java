package leetcode;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/building-h2o/
 */
public class Problem1117 {
    private static class H2O {
        private final Semaphore hSemaphore = new Semaphore(2, true);
        private final Semaphore oSempahore = new Semaphore(0, true);

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

    public static void main(String[] args) throws Exception {
        H2O h2o = new H2O();
        h2o.oxygen(() -> System.out.print("O"));
        Thread t1 = new Thread(() -> {
            try {
                h2o.hydrogen(() -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.print("H");
                    }
                });
            } catch (Exception e) {}
        });
        Thread t2 = new Thread(() -> {
            try {
                h2o.oxygen(() -> {
                    for (int i = 0; i < 5; i++) {
                        System.out.print("O");
                    }
                });
            } catch (Exception e) {}
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
