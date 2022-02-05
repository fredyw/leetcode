package leetcode

/**
 * https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */
class Problem1604 {
    fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
        TODO()
    }
}

fun main() {
    val prob = Problem1604()
    println(prob.alertNames(
        arrayOf("daniel","daniel","daniel","luis","luis","luis","luis"),
        arrayOf("10:00","10:40","11:00","09:00","11:00","13:00","15:00"))) // ["daniel"]
    println(prob.alertNames(
        arrayOf("alice","alice","alice","bob","bob","bob","bob"),
        arrayOf("12:01","12:00","18:00","21:00","21:20","21:30","23:00"))) // ["bob"]
}