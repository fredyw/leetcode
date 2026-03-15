// https://leetcode.com/problems/count-commas-in-range/description/
pub fn count_commas(n: i32) -> i32 {
    if n < 1000 {
        0
    } else {
        n - 1000 + 1
    }
}

fn main() {
    println!("{}", count_commas(1002)); // 3
    println!("{}", count_commas(998)); // 0
    println!("{}", count_commas(10003)); // 9004
}
