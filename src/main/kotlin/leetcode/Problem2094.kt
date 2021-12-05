package leetcode

/**
 * https://leetcode.com/problems/finding-3-digit-even-numbers/
 */
class Problem2094 {
    fun findEvenNumbers(digits: IntArray): IntArray {
        TODO()
    }
}

fun main() {
    val prob = Problem2094()
    println(prob.findEvenNumbers(intArrayOf(2,1,3,0))) // [102,120,130,132,210,230,302,310,312,320]
    println(prob.findEvenNumbers(intArrayOf(2,2,8,8,2))) // [222,228,282,288,822,828,882]
    println(prob.findEvenNumbers(intArrayOf(3,7,5))) // []
    println(prob.findEvenNumbers(intArrayOf(0,2,0,0))) // [200]
    println(prob.findEvenNumbers(intArrayOf(0,0,0))) // []
}