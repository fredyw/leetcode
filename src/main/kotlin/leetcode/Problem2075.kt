package leetcode

/**
 * https://leetcode.com/problems/decode-the-slanted-ciphertext/
 */
class Problem2075 {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        val cols = encodedText.length / rows
        var answer = StringBuilder()
        var row = 0
        var col = 0
        var count = 0
        while (true) {
            if (row == rows) {
                row = 0
                col -= rows - 1
            }
            if (col == cols) {
                break
            }
            val index = (row * cols) + col
            answer.append(encodedText[index])
            row++
            col++
            count++
        }
        return answer.trimEnd().toString()
    }
}
