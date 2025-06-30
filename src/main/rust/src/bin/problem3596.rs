// https://leetcode.com/problems/minimum-cost-path-with-alternating-directions-i/description/
pub fn min_cost(m: i32, n: i32) -> i32 {
    match (m, n) {
        (1, 1) => 1,
        (1, 2) => 3,
        (2, 1) => 3,
        _ => -1,
    }
}

fn main() {
    println!("{}", min_cost(1, 1)); // 1
    println!("{}", min_cost(2, 1)); // 3
    println!("{}", min_cost(2, 2)); // -1
    println!("{}", min_cost(1000000, 1000000)); // -1
}
