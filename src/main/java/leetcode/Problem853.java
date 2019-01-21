package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/car-fleet/
 */
public class Problem853 {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; ++i) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }
        double maxSoFar = 0;
        int answer = 0;
        List<Double> timeNeeded = new ArrayList<>(map.values());
        for (int i = position.length - 1; i >= 0; i--) {
            if (timeNeeded.get(i) > maxSoFar) {
                maxSoFar = timeNeeded.get(i);
                answer++;
            }
        }
        return answer;
    }
}
