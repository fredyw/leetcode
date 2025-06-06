// https://leetcode.com/problems/find-minimum-log-transportation-cost/description/
pub fn min_cutting_cost(n: i32, m: i32, k: i32) -> i64 {
    if n <= k && m <= k {
        0
    } else if n > k {
        (n as i64 - k as i64) * k as i64
    } else {
        (m as i64 - k as i64) * k as i64
    }
}

fn main() {
    println!("{}", min_cutting_cost(6, 5, 5)); // 5
    println!("{}", min_cutting_cost(4, 4, 6)); // 0
    println!("{}", min_cutting_cost(20, 60, 100)); // 0
    println!("{}", min_cutting_cost(4, 3, 3)); // 3
    println!("{}", min_cutting_cost(6, 3, 3)); // 9
}
