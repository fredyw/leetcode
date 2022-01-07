package leetcode

class Problem1865 {
    class FindSumPairs(nums1: IntArray, nums2: IntArray) {
        fun add(index: Int, `val`: Int) {
            TODO()
        }

        fun count(tot: Int): Int {
            TODO()
        }
    }
}

fun main() {
    val findSumPairs = Problem1865.FindSumPairs(intArrayOf(1, 1, 2, 2, 2, 3), intArrayOf(1, 4, 5, 2, 5, 4))
    println(findSumPairs.count(7))  // return 8; pairs (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) make 2 + 5 and pairs (5,1), (5,5) make 3 + 4
    findSumPairs.add(3, 2) // now nums2 = [1,4,5,4,5,4]
    println(findSumPairs.count(8))  // return 2; pairs (5,2), (5,4) make 3 + 5
    println(findSumPairs.count(4))  // return 1; pair (5,0) makes 3 + 1
    findSumPairs.add(0, 1) // now nums2 = [2,4,5,4,5,4]
    findSumPairs.add(1, 1) // now nums2 = [2,5,5,4,5,4]
    println(findSumPairs.count(7))  // return 11; pairs (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) make 2 + 5 and pairs (5,3), (5,5) make 3 + 4
}