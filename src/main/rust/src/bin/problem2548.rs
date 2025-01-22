use std::cmp::Ordering;

// https://leetcode.com/problems/maximum-price-to-fill-a-bag/description/
pub fn max_price(mut items: Vec<Vec<i32>>, mut capacity: i32) -> f64 {
    items.sort_by(|a, b| {
        let price_per_item1 = a[0] as f64 / a[1] as f64;
        let price_per_item2 = b[0] as f64 / b[1] as f64;
        if price_per_item1 < price_per_item2 {
            Ordering::Greater
        } else if price_per_item1 == price_per_item2 {
            Ordering::Equal
        } else {
            Ordering::Less
        }
    });
    let mut answer = 0.0;
    let mut capacity = capacity as f64;
    for item in items {
        let price = item[0] as f64;
        let weight = item[1] as f64;
        let price_per_item = price / weight;
        if weight <= capacity {
            answer += price_per_item * weight;
            capacity -= weight;
        } else {
            answer += price_per_item * capacity;
            capacity = 0.0;
        }
    }
    if capacity > 0.0 {
        -1.0
    } else {
        answer
    }
}

fn main() {
    println!("{}", max_price(vec![vec![50, 1], vec![10, 8]], 5)); // 55.00000
    println!("{}", max_price(vec![vec![100, 30]], 50)); // -1.00000
    println!("{}", max_price(vec![vec![100, 60]], 50)); // 83.33333
    println!("{}", max_price(vec![vec![100, 60], vec![200, 100]], 50)); // 100.00000
    println!("{}", max_price(vec![vec![500, 1000], vec![200, 100]], 50)); // 100.00000
}
