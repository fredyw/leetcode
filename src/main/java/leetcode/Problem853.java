package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/car-fleet/
 */
public class Problem853 {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) {
            return 0;
        }
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; ++i) {
            cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }
        Arrays.sort(cars, Comparator.comparingInt(a -> a.position));
        int answer = 1;
        for (int i = cars.length - 1; i > 0; i--) {
            if (cars[i].time < cars[i - 1].time) {
                answer++;
            } else {
                cars[i - 1] = cars[i];
            }
        }
        return answer;
    }

    private static class Car {
        private final int position;
        private final double time;

        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}
