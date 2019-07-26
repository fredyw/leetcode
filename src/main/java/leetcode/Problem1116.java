package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * https://leetcode.com/problems/print-zero-even-odd/
 */
public class Problem1116 {
    private static class ZeroEvenOdd {
        private int n;
        private final Semaphore zeroSempahore = new Semaphore(1);
        private final Semaphore oddSempahore = new Semaphore(0);
        private final Semaphore evenSempahore = new Semaphore(0);
        private boolean odd = true;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zeroSempahore.acquire();
                printNumber.accept(0);
                if (odd) {
                    oddSempahore.release();
                } else {
                    evenSempahore.release();
                }
                odd = !odd;
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                evenSempahore.acquire();
                printNumber.accept(i);
                zeroSempahore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSempahore.acquire();
                printNumber.accept(i);
                zeroSempahore.release();
            }
        }
    }
}
