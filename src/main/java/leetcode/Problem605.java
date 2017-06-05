package leetcode;

/**
 * https://leetcode.com/problems/can-place-flowers/
 */
public class Problem605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem605 prob = new Problem605();
        System.out.println(prob.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)); // true
        System.out.println(prob.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)); // false
        System.out.println(prob.canPlaceFlowers(new int[]{1, 0, 1, 0, 1}, 2)); // false
        System.out.println(prob.canPlaceFlowers(new int[]{1, 0, 1, 0, 1}, 3)); // false
        System.out.println(prob.canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 0, 1}, 3)); // true
        System.out.println(prob.canPlaceFlowers(new int[]{0, 0, 0, 1, 0, 0, 1}, 1)); // true
        System.out.println(prob.canPlaceFlowers(new int[]{0, 0, 0, 1, 0, 0, 1}, 2)); // false
    }
}
