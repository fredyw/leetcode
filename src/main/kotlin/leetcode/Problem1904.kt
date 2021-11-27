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
        finishMinute += 60
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
        val roundsInHours = (finishHour - startHour - 1) * 4
        val roundsInMinutes = (finishMinute - startMinute) / 15
        return if (roundsInHours + roundsInMinutes < 0) 0 else roundsInHours + roundsInMinutes
    }
}
