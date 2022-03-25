package leetcode

/**
 * https://leetcode.com/problems/stock-price-fluctuation/
 */
class Problem2034 {
    class StockPrice() {
        fun update(timestamp: Int, price: Int) {
            TODO()
        }

        fun current(): Int {
            TODO()
        }

        fun maximum(): Int {
            TODO()
        }

        fun minimum(): Int {
            TODO()
        }
    }
}

fun main() {
    val stockPrice = Problem2034.StockPrice()
    stockPrice.update(1, 10) // Timestamps are [1] with corresponding prices [10].
    stockPrice.update(2, 5) // Timestamps are [1,2] with corresponding prices [10,5].
    println(stockPrice.current()) // return 5, the latest timestamp is 2 with the price being 5.
    println(stockPrice.maximum()) // return 10, the maximum price is 10 at timestamp 1.
    println(stockPrice.update(1, 3)) // The previous timestamp 1 had the wrong price, so it is updated to 3.
    // Timestamps are [1,2] with corresponding prices [3,5].
    // Timestamps are [1,2] with corresponding prices [3,5].
    println(stockPrice.maximum()) // return 5, the maximum price is 5 after the correction.
    stockPrice.update(4, 2) // Timestamps are [1,2,4] with corresponding prices [3,5,2].
    println(stockPrice.minimum()) // return 2, the minimum price is 2 at timestamp 4.
}