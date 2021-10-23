package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/design-authentication-manager/
 */
class Problem1797 {
    class AuthenticationManager(private val timeToLive: Int) {
        private val tokenToExpirationTimeMap = mutableMapOf<String, Int>()
        private val expirationTimeSet = TreeSet<Int>()

        fun generate(tokenId: String, currentTime: Int) {
            tokenToExpirationTimeMap[tokenId] = currentTime + timeToLive
            expirationTimeSet += currentTime + timeToLive
        }

        fun renew(tokenId: String, currentTime: Int) {
            val expirationTime = tokenToExpirationTimeMap[tokenId] ?: return
            if (currentTime < expirationTime) {
                tokenToExpirationTimeMap[tokenId] = currentTime + timeToLive
                expirationTimeSet -= expirationTime
                expirationTimeSet += currentTime + timeToLive
            }
        }

        fun countUnexpiredTokens(currentTime: Int): Int {
            return expirationTimeSet.tailSet(currentTime, false).size
        }
    }
}
