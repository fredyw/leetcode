package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/
 */
class Problem2260 {
    fun minimumCardPickup(cards: IntArray): Int {
        var answer = -1
        val map = mutableMapOf<Int, Int>()
        for ((index, card) in cards.withIndex()) {
            if (card in map) {
                if (answer == -1) {
                    answer = index - map[card]!! + 1
                } else {
                    answer = min(answer, index - map[card]!! + 1)
                }
            }
            map[card] = index
        }
        return answer
    }
}
