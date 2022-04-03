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
        if (numArrows == 0) {
            if (sum > answer.max) {
                answer.max = sum
                answer.bobArrows = bobArrows.copyOf()
            }
            return
        }
        if (index == aliceArrows.size) {
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

fun main() {
    val prob = Problem2212()
//    println(prob.maximumBobPoints(9, intArrayOf(1,1,0,1,0,0,2,1,0,1,2,0)).contentToString()) // [0,0,0,0,1,1,0,0,1,2,3,1]
//    println(prob.maximumBobPoints(3, intArrayOf(0,0,1,0,0,0,0,0,0,0,0,2)).contentToString()) // [0,0,0,0,0,0,0,0,1,1,1,0]
    println(prob.maximumBobPoints(89, intArrayOf(3,2,28,1,7,1,16,7,3,13,3,5)).contentToString()) // [21,3,0,2,8,2,17,8,4,14,4,6]
}
