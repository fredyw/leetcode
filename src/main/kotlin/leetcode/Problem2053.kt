package leetcode

/**
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/
 */
class Problem2053 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2053()
    println(prob.kthDistinct(arrayOf("d","b","c","b","c","a"), 2)) // "a"
    println(prob.kthDistinct(arrayOf("aaa","aa","a"), 1)) // "aaa"
    println(prob.kthDistinct(arrayOf("a","b","a"), 3)) // ""
}
