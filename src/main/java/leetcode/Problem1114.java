package leetcode;

/**
 * https://leetcode.com/problems/print-in-order/
 */
public class Problem1114 {
    private static class Foo {
        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    public static void main(String[] args) {
        Problem1114 prob = new Problem1114();
    }
}
