package leetcode

/**
 * https://leetcode.com/problems/count-number-of-texts/
 */
class Problem2266 {
    fun countTexts(pressedKeys: String): Int {
        if (pressedKeys.length == 1) {
            return 1
        }
        var answer = 1L
        var i = 0
        var length = 1
        val memo3 = IntArray(pressedKeys.length + 1) { -1 }
        val memo4 = IntArray(pressedKeys.length + 1) { -1 }
        while (i < pressedKeys.length - 1) {
            if (pressedKeys[i] != pressedKeys[i + 1]) {
                val numDigits = numDigits(pressedKeys[i])
                answer = (answer * countTexts(
                    numDigits,
                    length,
                    if (numDigits == 3) memo3 else memo4
                )) % 1_000_000_007
                length = 1
            } else {
                length++
            }
            i++
        }
        val numDigits = numDigits(pressedKeys[i])
        answer = (answer * countTexts(
            numDigits,
            length,
            if (numDigits == 3) memo3 else memo4
        )) % 1_000_000_007
        return answer.toInt()
    }

    private fun numDigits(key: Char): Int {
        return if (key == '7' || key == '9') 4 else 3
    }

    private fun countTexts(numDigits: Int, length: Int, memo: IntArray): Int {
        if (length < 0) {
            return 0
        }
        if (length == 0) {
            return 1
        }
        if (memo[length] != -1) {
            return memo[length]
        }
        var count = 0
        for (digit in 1..numDigits) {
            count = (count + countTexts(numDigits, length - digit, memo)) % 1_000_000_007
        }
        memo[length] = count
        return count
    }
}
