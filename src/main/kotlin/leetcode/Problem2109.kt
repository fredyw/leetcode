package leetcode

/**
 * https://leetcode.com/problems/adding-spaces-to-a-string/
 */
class Problem2109 {
    fun addSpaces(s: String, spaces: IntArray): String {
        var answer = StringBuilder()
        var j = 0
        for (i in s.indices) {
            if (j < spaces.size && i == spaces[j]) {
                answer.append(' ').append(s[i])
                j++
            } else {
                answer.append(s[i])
            }
        }
        return answer.toString()
    }
}
