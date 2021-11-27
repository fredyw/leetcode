package leetcode

/**
 * https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/
 */
class Problem1904 {
    fun numberOfRounds(startTime: String, finishTime: String): Int {
        var (startHour, startMinute) = startTime.split(":").map { it.toInt() }
        var (finishHour, finishMinute) = finishTime.split(":").map { it.toInt() }
        if (startHour > finishHour || (startHour == finishHour && startMinute > finishMinute)) {
           finishHour += 24
        }
        val roundsInHours = if (startMinute <= finishMinute) (finishHour - startHour) * 4
            else (finishHour - startHour - 1) * 4
        if (startMinute > finishMinute) {
            finishMinute += 60
        }
        when (startMinute) {
            in 1..15 -> {
                startMinute = 15
            }
            in 16..30 -> {
                startMinute = 30
            }
            in 31..45 -> {
                startMinute = 45
            }
            in 46..60 -> {
                startMinute = 60
            }
        }
        when (finishMinute) {
            in 1..14 -> {
                finishMinute = 0
            }
            in 15..29 -> {
                finishMinute = 15
            }
            in 30..44 -> {
                finishMinute = 30
            }
            in 45..59 -> {
                finishMinute = 45
            }
            in 60..74 -> {
                finishMinute = 60
            }
            in 75..89 -> {
                finishMinute = 75
            }
            in 90..104 -> {
                finishMinute = 90
            }
            in 105..119 -> {
                finishMinute = 105
            }
        }
        val roundsInMinutes = if (startMinute > finishMinute) 0 else (finishMinute - startMinute) / 15
        return roundsInHours + roundsInMinutes
    }
}

fun main() {
    val prob = Problem1904()
//    println(prob.numberOfRounds("12:01", "12:44")) // 1
//    println(prob.numberOfRounds("20:00", "06:00")) // 40
//    println(prob.numberOfRounds("00:00", "23:59")) // 95
//    println(prob.numberOfRounds("00:01", "23:59")) // 94
//    println(prob.numberOfRounds("05:44", "23:00")) // 69
//    println(prob.numberOfRounds("05:44", "23:15")) // 70
//    println(prob.numberOfRounds("12:01", "12:16")) // 0
//    println(prob.numberOfRounds("12:15", "12:20")) // 0
//    println(prob.numberOfRounds("12:20", "12:15")) // 95
//    println(prob.numberOfRounds("12:01", "13:46")) // 6
//    println(prob.numberOfRounds("12:46", "13:01")) // 0
//    println(prob.numberOfRounds("12:48", "12:49")) // 0
//    println(prob.numberOfRounds("18:51", "04:54")) // 39
//    println(prob.numberOfRounds("23:51", "01:54")) // 7
    println(prob.numberOfRounds("22:51", "23:54")) // 3
}