package leetcode;

import java.util.concurrent.Semaphore;

/**
 * https://leetcode.com/problems/print-foobar-alternately/
 */
public class Problem1115 {
    private static class FooBar {
        private int n;
        private final Semaphore fooSemaphore = new Semaphore(0);
        private final Semaphore barSemaphore = new Semaphore(1);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barSemaphore.release();
            }
        }
    }
}
