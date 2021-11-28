package leetcode

/**
 * https://leetcode.com/problems/count-common-words-with-one-occurrence/
 */
class Problem2085 {
    fun countWords(words1: Array<String>, words2: Array<String>): Int {
        val map1 = mutableMapOf<String, Int>()
        words1.forEach { map1[it] = (map1[it] ?: 0) + 1 }
        val map2 = mutableMapOf<String, Int>()
        words2.forEach { map2[it] = (map2[it] ?: 0) + 1 }
        var answer = 0
        for ((key1, count1) in map1) {
            if (count1 > 1) {
                continue
            }
            val count2 = map2[key1]
            if (count2 != null && count2 == 1) {
                answer++
            }
        }
        return answer
    }
}
