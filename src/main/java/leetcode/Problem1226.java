package leetcode;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/the-dining-philosophers/
 */
public class Problem1226 {
    private static class DiningPhilosophers {
        private final Semaphore[] semaphores = new Semaphore[5];

        public DiningPhilosophers() {
            for (int i = 0; i < semaphores.length; i++) {
                semaphores[i] = new Semaphore(1);
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
            Semaphore left = semaphores[philosopher];
            Semaphore right = (philosopher == 0) ? semaphores[4] : semaphores[philosopher - 1];

            if (philosopher % 2 == 0) {
                left.acquire();
                pickLeftFork.run();
                right.acquire();
                pickRightFork.run();
            } else {
                right.acquire();
                pickRightFork.run();
                left.acquire();
                pickLeftFork.run();
            }

            eat.run();

            if (philosopher % 2 == 0) {
                putRightFork.run();
                right.release();
                putLeftFork.run();
                left.release();
            } else {
                putLeftFork.run();
                left.release();
                putRightFork.run();
                right.release();
            }
        }
    }
}
