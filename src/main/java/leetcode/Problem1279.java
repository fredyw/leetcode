package leetcode;

// https://leetcode.com/problems/traffic-light-controlled-intersection/description/
public class Problem1279 {
    public static class TrafficLight {
        private int greenRoad;

        public TrafficLight() {
            this.greenRoad = 1;
        }

        public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on (1 or 2)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Turns light to green on current road
            Runnable crossCar    // Makes car cross the intersection
        ) {
            synchronized(this) {
                if (greenRoad != roadId) {
                    turnGreen.run();
                    greenRoad = roadId;
                }
                crossCar.run();
            }
        }
    }
}
