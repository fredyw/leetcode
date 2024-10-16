// https://leetcode.com/problems/maximum-linear-stock-score/description/
pub fn max_score(prices: Vec<i32>) -> i64 {
    todo!()
}

fn main() {
    println!("{}", max_score(vec![1, 5, 3, 7, 8])); // 20
    println!("{}", max_score(vec![5, 6, 7, 8, 9])); // 35
    println!("{}", max_score(vec![1, 5, 3])); // 5
    println!("{}", max_score(vec![1])); // 1
    println!("{}", max_score(vec![1, 2, 3])); // 6
    println!("{}", max_score(vec![1, 2, 1, 1, 5])); // 8
}
