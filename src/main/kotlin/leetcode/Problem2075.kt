package leetcode

/**
 * https://leetcode.com/problems/decode-the-slanted-ciphertext/
 */
class Problem2075 {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        TODO()
    }
}

fun main() {
    val prob = Problem2075()
    println(prob.decodeCiphertext("ch   ie   pr", 3)) // "cipher"
    println(prob.decodeCiphertext("iveo    eed   l te   olc", 4)) // "i love leetcode"
    println(prob.decodeCiphertext("coding", 1)) // "coding"
    println(prob.decodeCiphertext(" b  ac", 2)) // " abc"
}