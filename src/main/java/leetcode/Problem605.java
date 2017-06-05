package leetcode;

/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class Problem605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int idx = 0;
        int flowers = 0;
        boolean foundOne = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                foundOne = true;
                int zeros = i - idx;
                if (flowerbed[idx] == 1) {
                    zeros--;
                }
                if (zeros >= 2) {
                    if (flowerbed[idx] == 1) {
                        flowers += (zeros - 1) / 2;
                    } else {
                        flowers += zeros / 2;
                    }
                }
                idx = i;
            }
        }
        if (!foundOne) {
            flowers += (flowerbed.length + 1) / 2;
        } else {
            int zeros = flowerbed.length - idx;
            if (flowerbed[idx] == 1) {
                zeros--;
            }
            if (zeros >= 2) {
                flowers += zeros / 2;
            }
        }
        return flowers >= n;
    }
}
