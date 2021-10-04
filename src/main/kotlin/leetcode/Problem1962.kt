package leetcode

import java.util.PriorityQueue
import java.util.Comparator
import kotlin.math.ceil

/**
 * https://leetcode.com/problems/remove-stones-to-minimize-the-total/
 */
class Problem1962 {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val queue = PriorityQueue(Comparator<Int> { a, b -> b.compareTo(a) })
        for (pile in piles) {
            queue.add(pile)
        }
        for (i in 1..k) {
            val max = ceil(queue.poll() / 2.0).toInt()
            queue.add(max)
        }
        return queue.sum()
    }
}
