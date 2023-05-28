// https://leetcode.com/problems/buy-two-chocolates/
pub fn buy_choco(mut prices: Vec<i32>, money: i32) -> i32 {
    prices.sort();
    if prices[0] + prices[1] <= money {
        money - (prices[0] + prices[1])
    } else {
        money
    }
}

fn main() {
    println!("{}", buy_choco(vec![1, 2, 2], 3)); // 0
    println!("{}", buy_choco(vec![3, 2, 3], 3)); // 3
}
