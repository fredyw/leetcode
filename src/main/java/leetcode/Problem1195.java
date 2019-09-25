package leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/fizz-buzz-multithreaded/
 */
public class Problem1195 {
    private static class FizzBuzz {
        private int n;
        private final AtomicInteger count = new AtomicInteger(1);
        private final Semaphore fizzSemaphore = new Semaphore(0);
        private final Semaphore buzzSemaphore = new Semaphore(0);
        private final Semaphore fizzBuzzSemaphore = new Semaphore(0);
        private final Semaphore numberSemaphore = new Semaphore(1);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (count.get() <= n) {
                fizzSemaphore.acquire();
                if (count.get() > n) {
                    break;
                }
                if (count.get() % 3 == 0 && count.get() <= n) {
                    printFizz.run();
                }
                release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (count.get() <= n) {
                buzzSemaphore.acquire();
                if (count.get() > n) {
                    break;
                }
                if (count.get() % 5 == 0 && count.get() <= n) {
                    printBuzz.run();
                }
                release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (count.get() <= n) {
                fizzBuzzSemaphore.acquire();
                if (count.get() > n) {
                    break;
                }
                if (count.get() % 3 == 0 && count.get() % 5 == 0) {
                    printFizzBuzz.run();
                }
                release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (count.get() <= n) {
                numberSemaphore.acquire();
                if (count.get() > n) {
                    break;
                }
                if (count.get() % 3 != 0 && count.get() % 5 != 0) {
                    printNumber.accept(count.get());
                }
                release();
            }
        }

        private void release() {
            int next = count.incrementAndGet();
            if (next > n) {
                fizzBuzzSemaphore.release();
                fizzSemaphore.release();
                buzzSemaphore.release();
                numberSemaphore.release();
            } else {
                if (next % 3 == 0 && next % 5 == 0) {
                    fizzBuzzSemaphore.release();
                } else if (next % 3 == 0) {
                    fizzSemaphore.release();
                } else if (next % 5 == 0) {
                    buzzSemaphore.release();
                } else {
                    numberSemaphore.release();
                }
            }
        }
    }
}
