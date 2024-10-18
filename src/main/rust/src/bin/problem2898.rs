use std::collections::HashMap;

// https://leetcode.com/problems/maximum-linear-stock-score/description/
pub fn max_score(prices: Vec<i32>) -> i64 {
    let mut map: HashMap<i32, i64> = HashMap::new();
    for (i, price) in prices.into_iter().enumerate() {
        *map.entry(price - i as i32).or_insert(0) += price as i64;
    }
    let mut answer = 0;
    for (_, sum) in map {
        answer = answer.max(sum);
    }
    answer
}

fn main() {
    println!("{}", max_score(vec![1, 5, 3, 7, 8])); // 20
    println!("{}", max_score(vec![5, 6, 7, 8, 9])); // 35
    println!("{}", max_score(vec![1, 5, 3])); // 5
    println!("{}", max_score(vec![1])); // 1
    println!("{}", max_score(vec![1, 2, 3])); // 6
    println!("{}", max_score(vec![1, 2, 1, 1, 5])); // 8
}
