package leetcode;

/**
 * https://leetcode.com/problems/lemonade-change/
 */
public class Problem860 {
    public boolean lemonadeChange(int[] bills) {
        // 0: count of 5
        // 1: count of 10
        // 2: count of 20
        int[] change = new int[3];
        for (int bill : bills) {
            change[index(bill)]++;
            if (bill == 10) {
                if (change[index(5)] == 0) {
                    return false;
                }
                change[index(5)]--;
            } else if (bill == 20) {
                if (change[index(5)] == 0) {
                    return false;
                }
                if (change[index(10)] == 0) {
                    if (change[0] < 3) {
                        return false;
                    }
                    change[index(5)] -= 3;
                } else {
                    change[index(10)]--;
                    change[index(5)]--;
                }
            }
        }
        return true;
    }

    private static int index(int bill) {
        if (bill == 5) {
            return 0;
        }
        if (bill == 10) {
            return 1;
        }
        return 2;
    }
}
