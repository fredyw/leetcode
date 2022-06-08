package leetcode

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/
 */
class Problem1717 {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var answer = 0
        var sb = StringBuilder(s)
        while (true) {
            if (x > y) {
                var i = sb.indexOf("ab")
                if (i < 0) {
                    i = sb.indexOf("ba")
                    if (i < 0) {
                        break
                    }
                    answer += y
                } else {
                    answer += x
                }
                sb.delete(i, i + 2)
            } else {
                var i = sb.indexOf("ba")
                if (i < 0) {
                    i = sb.indexOf("ab")
                    if (i < 0) {
                        break
                    }
                    answer += x
                } else {
                    answer += y
                }
                sb.delete(i, i + 2)
            }
        }
        return answer
    }
}

fun main() {
    val prob = Problem1717()
    println(prob.maximumGain("cdbcbbaaabab", 4, 5)) // 19
    println(prob.maximumGain("aabbaaxybbaabb", 5, 4)) // 20
}