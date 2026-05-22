// https://leetcode.com/problems/minimize-xor/description/
pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
    let num1_bits = num1.count_ones();
    let num2_bits = num2.count_ones();
    let mut answer = num1;
    while num1_bits > num2_bits && (num1_bits - num2_bits > 0) {
        answer &= answer - 1;
    }
    answer
}

fn main() {
    println!("{}", minimize_xor(3, 5)); // 3
    // println!("{}", minimize_xor(1, 12)); // 3
}
