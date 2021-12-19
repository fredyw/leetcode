package leetcode

/**
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 */
class Problem2108 {
    fun firstPalindrome(words: Array<String>): String {
        for (word in words) {
            if (isPalindrome(word)) {
                return word
            }
        }
        return ""
    }

    private fun isPalindrome(word: String): Boolean {
        var i = 0
        var j = word.length - 1
        while (i < j) {
            if (word[i] != word[j]) {
                return false
            }
            i++
            j--
        }
        return true
    }
}
