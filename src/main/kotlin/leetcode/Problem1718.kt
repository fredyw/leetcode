package leetcode

/**
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
 */
class Problem1718 {
    fun constructDistancedSequence(n: Int): IntArray {
        return constructDistancedSequence(n, 0, HashSet(), IntArray(n * 2 - 1)).array
    }

    private class Answer(val found: Boolean, val array: IntArray)

    private fun constructDistancedSequence(n: Int, index: Int,
                                           visited: MutableSet<Int>, array: IntArray): Answer {
        if (visited.size == n) {
            return Answer(true, array)
        }
        if (array[index] != 0) {
            return constructDistancedSequence(n, index + 1, visited, array)
        }
        for (i in n downTo 1) {
            if (i in visited) {
                continue
            }
            if (i == 1) {
                array[index] = i
            } else {
                if (index + i >= array.size || array[index + i] != 0) {
                    continue
                }
                array[index] = i
                array[index + i] = i
            }
            visited += i
            val answer = constructDistancedSequence(n, index + 1, visited, array)
            if (answer.found) {
                return answer
            }
            visited -= i
            array[index] = 0
            if (i != 1) {
                array[index + i] = 0
            }
        }
        return Answer(false, array)
    }
}
