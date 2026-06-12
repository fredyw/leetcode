package leetcode

/** https://leetcode.com/problems/capitalize-the-title/ */
class Problem2129 {
    fun capitalizeTitle(title: String): String {
        return title.split(" ").joinToString(" ") {
            if (it.length > 2) it[0].uppercaseChar() + it.substring(1).lowercase()
            else it.lowercase()
        }
    }
}
