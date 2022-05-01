package leetcode

/**
 * https://leetcode.com/problems/detect-squares/
 */
class Problem2013 {
    class DetectSquares() {
        fun add(point: IntArray) {
            TODO()
        }

        fun count(point: IntArray): Int {
            TODO()
        }
    }
}

fun main() {
    val detectSquares = Problem2013.DetectSquares()
    detectSquares.add(intArrayOf(3, 10))
    detectSquares.add(intArrayOf(11, 2))
    detectSquares.add(intArrayOf(3, 2))
    println(detectSquares.count(intArrayOf(11, 10))) // 1
    println(detectSquares.count(intArrayOf(14, 8)))  // 0
    detectSquares.add(intArrayOf(11, 2))
    println(detectSquares.count(intArrayOf(11, 10))) // 2
    detectSquares.add(intArrayOf(3, 10))
    detectSquares.add(intArrayOf(3, 2))
    println(detectSquares.count(intArrayOf(11, 10))) // 8
}