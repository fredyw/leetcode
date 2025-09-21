// https://leetcode.com/problems/bitwise-or-of-even-numbers-in-an-array/description/
pub fn even_number_bitwise_o_rs(nums: Vec<i32>) -> i32 {
    nums.into_iter()
        .filter(|&n| n & 1 == 0)
        .fold(0, |acc, n| acc | n)
}

fn main() {
    println!("{}", even_number_bitwise_o_rs(vec!(1, 2, 3, 4, 5, 6))); // 6
    println!("{}", even_number_bitwise_o_rs(vec!(7, 9, 11))); // 0
    println!("{}", even_number_bitwise_o_rs(vec!(1, 8, 16))); // 24
}
