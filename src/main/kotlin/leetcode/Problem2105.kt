package leetcode

/**
 * https://leetcode.com/problems/watering-plants-ii/
 */
class Problem2105 {
    fun minimumRefill(plants: IntArray, capacityA: Int, capacityB: Int): Int {
        var answer = 0
        var left = 0
        var right = plants.size - 1
        var alice = capacityA
        var bob = capacityB
        while (left <= right) {
            if (left == right) {
                if (alice > bob) {
                    if (alice < plants[left]) {
                        alice = capacityA - plants[left]
                        answer++
                    } else {
                        alice -= plants[left]
                    }
                } else {
                    if (bob < plants[right]) {
                        bob = capacityB - plants[right]
                        answer++
                    } else {
                        bob -= plants[right]
                    }
                }
            } else {
                if (alice < plants[left]) {
                    alice = capacityA - plants[left]
                    answer++
                } else {
                    alice -= plants[left]
                }
                if (bob < plants[right]) {
                    bob = capacityB - plants[right]
                    answer++
                } else {
                    bob -= plants[right]
                }
            }
            left++
            right--
        }
        return answer
    }
}
