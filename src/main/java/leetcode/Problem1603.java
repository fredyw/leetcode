package leetcode;

/**
 * https://leetcode.com/problems/design-parking-system/
 */
public class Problem1603 {
    static class ParkingSystem {
        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) { // big
                big--;
                return big >= 0;
            } else if (carType == 2) { // medium
                medium--;
                return medium >= 0;
            }
            // small
            small--;
            return small >= 0;
        }
    }
}
