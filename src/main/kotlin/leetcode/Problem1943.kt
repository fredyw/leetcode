package leetcode

/**
 * https://leetcode.com/problems/describe-the-painting/
 */
class Problem1943 {
    fun splitPainting(segments: Array<IntArray>): List<List<Long>> {
        segments.sortWith { a, b ->
            val cmp = a[0].compareTo(b[0])
            if (cmp == 0) {
                a[1].compareTo(b[1])
            } else {
                cmp
            }
        }
        return listOf()
    }
}

fun main() {
    val prob = Problem1943()
//    println(prob.splitPainting(arrayOf(
//        intArrayOf(1,4,5),
//        intArrayOf(4,7,7),
//        intArrayOf(1,7,9)))) // [[1,4,14],[4,7,16]]
//    println(prob.splitPainting(arrayOf(
//        intArrayOf(1,7,9),
//        intArrayOf(6,8,15),
//        intArrayOf(8,10,7)))) // [[1,6,9],[6,7,24],[7,8,15],[8,10,7]]
//    println(prob.splitPainting(arrayOf(
//        intArrayOf(1,4,5),
//        intArrayOf(1,4,7),
//        intArrayOf(4,7,1),
//        intArrayOf(4,7,11)))) // [[1,4,12],[4,7,12]]
//    println(prob.splitPainting(arrayOf(
//        intArrayOf(1,4,5),
//        intArrayOf(4,7,7),
//        intArrayOf(1,7,9),
//        intArrayOf(2,5,10),
//        intArrayOf(3,5,8),
//        intArrayOf(1,2,6),
//        intArrayOf(3,5,3),
//    ))) // [[1,2,20],[2,3,24],[3,4,35],[4,5,37],[5,7,16]]
    // [[1,4,5],[4,7,7],[1,7,9],[9,14,1],[10,16,3],[5,9,2],[6,8,4],[20,25,10]]
    println(prob.splitPainting(arrayOf(
        intArrayOf(1,4,5),
        intArrayOf(1,7,9),
        intArrayOf(4,7,7),
        intArrayOf(5,9,2),
        intArrayOf(6,8,4),
        intArrayOf(9,14,1),
        intArrayOf(10,16,3),
        intArrayOf(20,25,10),
    ))) // [[1,4,14],[4,5,16],[5,6,18],[6,7,22],[7,8,6],[8,9,2],[9,10,1],[10,14,4],[14,16,3],[20,25,10]]
}