package leetcode

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/stone-game-vi/
 */
class Problem1686 {
    fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
        data class Stone(val index: Int, val value: Int)
        val aliceQueue = PriorityQueue<Stone> { a, b -> b.value.compareTo(a.value) }
        aliceValues.forEachIndexed { index, value -> aliceQueue += Stone(index, value) }
        val bobQueue = PriorityQueue<Stone> { a, b -> b.value.compareTo(a.value) }
        bobValues.forEachIndexed { index, value -> bobQueue += Stone(index, value) }
        var n = aliceValues.size
        val removed = BooleanArray(n)
        var aliceValue = 0
        var bobValue = 0
        var aliceTurn = true
        while (n > 0) {
            while (aliceQueue.isNotEmpty() && removed[aliceQueue.peek().index]) {
                aliceQueue.poll()
            }
            while (bobQueue.isNotEmpty() && removed[bobQueue.peek().index]) {
                bobQueue.poll()
            }
            println("Turn: ${if (aliceTurn) "Alice" else "Bob"}")
            println("  Alice queue: $aliceQueue")
            println("  Bob queue  : $bobQueue")
            if (aliceQueue.peek().value < bobQueue.peek().value) {
                val bobStone = bobQueue.poll()
                if (aliceTurn) {
                    aliceValue += aliceValues[bobStone.index]
                } else {
                    bobValue += bobStone.value
                }
                removed[bobStone.index] = true
            } else {
                val aliceStone = aliceQueue.poll()
                if (aliceTurn) {
                    aliceValue += aliceStone.value
                } else {
                    bobValue += bobValues[aliceStone.index]
                }
                removed[aliceStone.index] = true
            }
            println("  Alice value: $aliceValue")
            println("  Bob value  : $bobValue")
            aliceTurn = !aliceTurn
            n--
        }
        return if (aliceValue > bobValue) 1
            else if (aliceValue == bobValue) 0
            else -1
    }
}

fun main() {
    val prob = Problem1686()
//    println(prob.stoneGameVI(intArrayOf(1,3), intArrayOf(2,1))) // 1
//    println(prob.stoneGameVI(intArrayOf(1,2), intArrayOf(3,1))) // 0
//    println(prob.stoneGameVI(intArrayOf(2,4,3), intArrayOf(1,6,7))) // -1
    println(prob.stoneGameVI(intArrayOf(2,9,1,1,1,3,5,8,8,6,8,6,2,4), intArrayOf(1,9,7,8,3,4,2,7,8,10,1,7,10,4))) // -1
}