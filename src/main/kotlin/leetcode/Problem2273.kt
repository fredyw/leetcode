package leetcode

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
 */
class Problem2273 {
    fun removeAnagrams(words: Array<String>): List<String> {
        var answer = mutableListOf<String>()
        answer.add(words[0])
        var i = 0
        while (i < words.size - 1) {
            if (!isAnagram(words[i], words[i + 1])) {
                answer.add(words[i + 1])
            }
            i++
        }
        return answer
    }

    private fun isAnagram(word1: String, word2: String): Boolean {
        val count1 = IntArray(26)
        for (c in word1) {
            count1[c - 'a']++
        }
        val count2 = IntArray(26)
        for (c in word2) {
            count2[c - 'a']++
        }
        return count1.contentEquals(count2)
    }
}

fun main() {
    val prob = Problem2273()
    println(prob.removeAnagrams(arrayOf("abba","baba","bbaa","cd","cd"))) // ["abba","cd"]
    println(prob.removeAnagrams(arrayOf("a","b","c","d","e"))) // ["a","b","c","d","e"]
}