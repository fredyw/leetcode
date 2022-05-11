package leetcode

/**
 * https://leetcode.com/problems/count-number-of-texts/
 */
class Problem2266 {
    fun countTexts(pressedKeys: String): Int {
        TODO()
    }
}

fun main() {
    val prob = Problem2266()
    println(prob.countTexts("22233")) // 8
    println(prob.countTexts("222")) // 4
    println(prob.countTexts("2222")) // 7
    println(prob.countTexts("22222")) // 13
    println(prob.countTexts("222222")) // 24
    println(prob.countTexts("2222222")) // 44
    println(prob.countTexts("222222222222222222222222222222222222")) // 82876089
}