package leetcode

/**
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 */
class Problem2038 {
    fun winnerOfGame(colors: String): Boolean {
        var alice = true
        var aliceIndex = 0
        var bobIndex = 0
        var answer = false
        while (true) {
            if (alice) {
                val result = find(colors, 'A', aliceIndex)
                if (!result.found) {
                    answer = false // Bob wins
                    break
                }
                aliceIndex = result.nextIndex
            } else {
                val result = find(colors, 'B', bobIndex)
                if (!result.found) {
                    answer = true // Alice wins
                    break
                }
                bobIndex = result.nextIndex
            }
            alice = !alice
        }
        return answer
    }

    private data class Result(val nextIndex: Int, val found: Boolean)

    private fun find(colors: String, color: Char, index: Int): Result {
        var i = if (index == 0) 1 else index
        while (i + 1 < colors.length) {
            if (colors[i - 1] == color && colors[i] == color && colors[i + 1] == color) {
                return Result(i + 1, true)
            } else {
                i++
            }
        }
        return Result(-1, false)
    }
}
