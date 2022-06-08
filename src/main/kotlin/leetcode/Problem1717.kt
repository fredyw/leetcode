package leetcode

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings/
 */
class Problem1717 {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var answer = 0
        var tmp = s
        while (true) {
            if (x > y) {
                var i = tmp.indexOf("ab")
                if (i < 0) {
                    i = tmp.indexOf("ba")
                    if (i < 0) {
                        break
                    }
                    answer += y
                } else {
                    answer += x
                }
                tmp = tmp.substring(0, i) + tmp.substring(i + 2)
            } else {
                var i = tmp.indexOf("ba")
                if (i < 0) {
                    i = tmp.indexOf("ab")
                    if (i < 0) {
                        break
                    }
                    answer += x
                } else {
                    answer += y
                }
                tmp = tmp.substring(0, i) + tmp.substring(i + 2)
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