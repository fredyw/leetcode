// https://leetcode.com/problems/minimum-cost-to-split-into-ones/description/
pub fn min_cost(n: i32) -> i32 {
    if n == 1 {
        return 0;
    }
    min_cost(n - 1) + (n - 1)
}

fn main() {
    println!("{}", min_cost(3)); // 3
    println!("{}", min_cost(4)); // 6
    println!("{}", min_cost(500)); // 6
}
