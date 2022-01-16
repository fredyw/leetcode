package leetcode

/**
 * https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
 */
class Problem2138 {
    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val answer = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            answer += if (i + k > s.length) {
                s.substring(i) + fill.toString().repeat(k - s.substring(i).length)
            } else {
                s.substring(i, i + k)
            }
            i += k
        }
        return answer.toTypedArray()
    }
}
