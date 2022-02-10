package leetcode

import kotlin.math.min

/**
 * https://leetcode.com/problems/sum-game/
 */
class Problem1927 {
    fun sumGame(num: String): Boolean {
        var mid = num.length / 2
        var leftSum = 0
        var leftUnknown = 0
        for (i in 0 until mid) {
            leftUnknown += if (num[i] == '?') 1 else 0
            leftSum += if (num[i] == '?') 0 else num[i].toString().toInt()
        }
        var rightSum = 0
        var rightUnknown = 0
        for (i in mid until num.length) {
            rightUnknown += if (num[i] == '?') 1 else 0
            rightSum += if (num[i] == '?') 0 else num[i].toString().toInt()
        }
        if (leftUnknown == 0 && rightUnknown == 0) {
            return leftSum != rightSum
        } else if ((leftUnknown + rightUnknown) % 2 != 0) {
            return true
        }
        val minUnknown = min(leftUnknown, rightUnknown)
        leftUnknown -= minUnknown
        rightUnknown -= minUnknown
        return ((leftUnknown * 9) / 2) + leftSum != ((rightUnknown * 9) / 2) + rightSum
    }
}
