package leetcode

/**
 * https://leetcode.com/problems/design-authentication-manager/
 */
class Problem1797 {
    class AuthenticationManager(private val timeToLive: Int) {
        fun generate(tokenId: String, currentTime: Int) {
            TODO()
        }

        fun renew(tokenId: String, currentTime: Int) {
            TODO()
        }

        fun countUnexpiredTokens(currentTime: Int): Int {
            TODO()
        }
    }
}

fun main() {
    val authenticationManager = Problem1797.AuthenticationManager(5)
    println(authenticationManager.renew("aaa", 1)) // No token exists with tokenId "aaa" at time 1, so nothing happens.
    authenticationManager.generate("aaa", 2) // Generates a new token with tokenId "aaa" at time 2.
    println(authenticationManager.countUnexpiredTokens(6)) // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
    authenticationManager.generate("bbb", 7) // Generates a new token with tokenId "bbb" at time 7.
    println(authenticationManager.renew("aaa", 8)) // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
    println(authenticationManager.renew("bbb", 10)) // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
    println(authenticationManager.countUnexpiredTokens(15)) // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
}