// https://leetcode.com/problems/find-the-maximum-achievable-number/
pub fn the_maximum_achievable_x(num: i32, t: i32) -> i32 {
    num + 2 * t
}

fn main() {
    println!("{}", the_maximum_achievable_x(4, 1)); // 6
    println!("{}", the_maximum_achievable_x(3, 2)); // 7
}
