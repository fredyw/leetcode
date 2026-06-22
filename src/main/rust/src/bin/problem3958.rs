// https://leetcode.com/problems/minimum-cost-to-split-into-ones-ii/description/
pub fn min_cost(n: i32) -> i64 {
    let n = n as i64;
    n * (n - 1) / 2
}

fn main() {
    println!("{}", min_cost(3)); // 3
    println!("{}", min_cost(4)); // 6
}
