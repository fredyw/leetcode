// https://leetcode.com/problems/most-expensive-item-that-can-not-be-bought/description/
pub fn most_expensive_item(prime_one: i32, prime_two: i32) -> i32 {
    // https://en.wikipedia.org/wiki/Coin_problem
    (prime_one * prime_two) - prime_one - prime_two
}

fn main() {
    println!("{}", most_expensive_item(2, 5)); // 3
    println!("{}", most_expensive_item(5, 7)); // 23
}
