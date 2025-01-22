// https://leetcode.com/problems/maximum-price-to-fill-a-bag/description/
pub fn max_price(items: Vec<Vec<i32>>, capacity: i32) -> f64 {
    todo!()
}

fn main() {
    println!("{}", max_price(vec![vec![50, 1], vec![10, 8]], 5)); // 55.00000
    println!("{}", max_price(vec![vec![100, 30]], 50)); // -1.00000
    println!("{}", max_price(vec![vec![100, 60]], 50)); // 83.33333
    println!("{}", max_price(vec![vec![100, 60], vec![200, 100]], 50)); // 100.00000
}
