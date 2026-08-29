// https://leetcode.com/problems/minimum-total-price-after-applying-discounts/description/
pub fn min_price(mut prices: Vec<i32>, mut discounts: Vec<i32>) -> f64 {
    prices.sort_unstable_by(|a, b| b.cmp(a));
    discounts.sort_unstable_by(|a, b| b.cmp(a));
    let mut answer: f64 = 0.0;
    let mut j = 0;
    for i in 0..prices.len() {
        if j < discounts.len() {
            answer += (prices[i] * (100 - discounts[j])) as f64 / 100.0;
        } else {
            answer += prices[i] as f64;
        }
        j += 1;
    }
    answer
}

fn main() {
    println!("{}", min_price(vec![10, 30, 21], vec![50, 60])); // 32.50000
    println!("{}", min_price(vec![100, 70], vec![10, 40, 50])); // 92.00000
    println!("{}", min_price(vec![7, 3, 9], vec![100, 100])); // 3.00000
}
