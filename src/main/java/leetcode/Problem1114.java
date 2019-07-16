package leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * https://leetcode.com/problems/print-in-order/
 */
public class Problem1114 {
    private static class Foo {
        private final CountDownLatch latch2 = new CountDownLatch(1);
        private final CountDownLatch latch3 = new CountDownLatch(1);
        private final Object obj1 = new Object();

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            latch2.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            latch2.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            latch3.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            latch3.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
