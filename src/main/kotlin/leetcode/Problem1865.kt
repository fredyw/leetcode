package leetcode

class Problem1865 {
    class FindSumPairs(val nums1: IntArray, val nums2: IntArray) {
        private val nums2Map = mutableMapOf<Int, Int>()

        init {
            for (num in nums2) {
                nums2Map[num] = (nums2Map[num] ?: 0) + 1
            }
        }

        fun add(index: Int, `val`: Int) {
            val oldCount = nums2Map[nums2[index]]!! - 1
            if (oldCount == 0) {
                nums2Map -= nums2[index]
            } else {
                nums2Map[nums2[index]] = oldCount
            }
            nums2[index] += `val`
            nums2Map[nums2[index]] = (nums2Map[nums2[index]] ?: 0) + 1
        }

        fun count(tot: Int): Int {
            var count = 0
            for (num1 in nums1) {
                val num2 = tot - num1
                count += nums2Map[num2] ?: 0
            }
            return count
        }
    }
}
