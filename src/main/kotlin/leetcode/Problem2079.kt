package leetcode

/**
 * https://leetcode.com/problems/watering-plants/
 */
class Problem2079 {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        var answer = 0
        var water = capacity
        for ((index, plant) in plants.withIndex()) {
            if (water - plant < 0) {
                water = capacity - plant
                answer += (index * 2) + 1
            } else {
                water -= plant
                answer++
            }
        }
        return answer
    }
}
