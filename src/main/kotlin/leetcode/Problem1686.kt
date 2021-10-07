package leetcode

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/stone-game-vi/
 */
class Problem1686 {
    fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
        data class Stone(val index: Int, val value: Int)
        val queue = PriorityQueue<Stone> { a, b -> b.value.compareTo(a.value) }
        for (index in aliceValues.indices) {
            queue += Stone(index, aliceValues[index] + bobValues[index])
        }
        var aliceValue = 0
        var bobValue = 0
        var aliceTurn = true
        while (queue.isNotEmpty()) {
            val stone = queue.poll()
            if (aliceTurn) {
                aliceValue += aliceValues[stone.index]
            } else {
                bobValue += bobValues[stone.index]
            }
            aliceTurn = !aliceTurn
        }
        return if (aliceValue > bobValue) 1
        else if (aliceValue == bobValue) 0
        else -1
    }
}
