package leetcode

/**
 * https://leetcode.com/problems/destroying-asteroids/
 */
class Problem2126 {
    fun asteroidsDestroyed(mass: Int, asteroids: IntArray): Boolean {
        asteroids.sort()
        var m = mass.toLong()
        for (asteroid in asteroids) {
            if (asteroid <= m) {
                m += asteroid
            } else {
                return false
            }
        }
        return true
    }
}
