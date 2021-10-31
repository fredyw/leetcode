package leetcode

/**
 * https://leetcode.com/problems/kth-distinct-string-in-an-array/
 */
class Problem2053 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val map = mutableMapOf<String, Int>()
        for (s in arr) {
            map[s] = (map[s] ?: 0) + 1
        }
        val distinctMap = map.filter { it.value == 1 }
        var count = k
        for (s in arr) {
            var distinct = s
            if (s in distinctMap) {
                count--
                if (count == 0) {
                    return distinct
                }
            }
        }
        return ""
    }
}

