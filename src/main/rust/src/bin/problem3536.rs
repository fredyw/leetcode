// https://leetcode.com/problems/maximum-product-of-two-digits/description/
pub fn max_product(n: i32) -> i32 {
    let mut v: Vec<i32> = n
        .to_string()
        .chars()
        .map(|c| c as i32 - '0' as i32)
        .collect();
    v.sort_by(|a, b| b.cmp(a));
    v[0] * v[1]
}

fn main() {
    println!("{}", max_product(31)); // 3
    println!("{}", max_product(22)); // 4
    println!("{}", max_product(124)); // 8
}
