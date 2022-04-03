package leetcode

/**
 * https://leetcode.com/problems/maximum-points-in-an-archery-competition/
 */
class Problem2212 {
    fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray): IntArray {
        val answer = Answer()
        maximumBobPoints(numArrows, aliceArrows, IntArray(12), 0, 0, answer)
        return answer.bobArrows
    }

    private data class Answer(var max: Int = 0, var bobArrows: IntArray = IntArray(12))

    private fun maximumBobPoints(numArrows: Int, aliceArrows: IntArray,
                                 bobArrows: IntArray, index: Int, sum: Int, answer: Answer) {
        if (index == aliceArrows.size) {
            if (sum > answer.max) {
                answer.max = sum
                answer.bobArrows = bobArrows.copyOf()
                answer.bobArrows[0] = numArrows
            }
            return
        }
        maximumBobPoints(numArrows, aliceArrows, bobArrows, index + 1, sum, answer)
        if (numArrows - (aliceArrows[index] + 1) >= 0) {
            bobArrows[index] = aliceArrows[index] + 1
            maximumBobPoints(numArrows - (aliceArrows[index] + 1),
                aliceArrows, bobArrows, index + 1, sum + index, answer)
            bobArrows[index] = 0
        }
    }
}

