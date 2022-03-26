package leetcode

import java.util.TreeMap

/**
 * https://leetcode.com/problems/stock-price-fluctuation/
 */
class Problem2034 {
    class StockPrice() {
        private val timestampToPriceMap = TreeMap<Int, Int>()
        private val priceToCountMap = TreeMap<Int, Int>()

        fun update(timestamp: Int, price: Int) {
            val existingPrice = timestampToPriceMap[timestamp]
            if (existingPrice != null) {
                val newCount = (priceToCountMap[existingPrice] ?: 0) - 1
                if (newCount > 0) {
                    priceToCountMap[existingPrice] = newCount
                } else if (newCount == 0) {
                    priceToCountMap -= existingPrice
                }
            }
            priceToCountMap[price] = (priceToCountMap[price] ?: 0) + 1
            timestampToPriceMap[timestamp] = price
        }

        fun current(): Int {
            return timestampToPriceMap[timestampToPriceMap.lastKey()]!!
        }

        fun maximum(): Int {
            return priceToCountMap.lastKey()
        }

        fun minimum(): Int {
            return priceToCountMap.firstKey()
        }
    }
}
