package leetcode

/**
 * https://leetcode.com/problems/cyclically-rotating-a-grid/
 */
class Problem1914 {
    fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
        TODO()
    }
}


fun main() {
    val prob = Problem1914()
    println(arrayOf(
        intArrayOf(40,10),
        intArrayOf(30,20), 1).contentDeepToString()) // [[10,20],[40,30]]
    println(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12),
        intArrayOf(13,14,15,16), 1).contentDeepToString()) // [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
}