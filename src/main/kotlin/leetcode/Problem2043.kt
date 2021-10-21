package leetcode

/**
 * https://leetcode.com/problems/simple-bank-system/
 */
class Problem2043 {
    class Bank(private val balance: LongArray) {
        fun transfer(account1: Int, account2: Int, money: Long): Boolean {
            if (!isValid(account1)) {
                return false
            }
            if (!isValid(account2)) {
                return false
            }
            if (!withdraw(account1, money)) {
                return false
            }
            return deposit(account2, money)
        }

        fun deposit(account: Int, money: Long): Boolean {
            if (!isValid(account)) {
                return false
            }
            balance[account - 1] += money
            return true
        }

        fun withdraw(account: Int, money: Long): Boolean {
            if (!isValid(account)) {
                return false
            }
            if (balance[account - 1] - money < 0) {
                return false
            }
            balance[account - 1] -= money
            return true
        }

        private fun isValid(account: Int): Boolean {
            return account >= 1 && account <= balance.size
        }
    }
}
