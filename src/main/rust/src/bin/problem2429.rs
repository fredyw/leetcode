// https://leetcode.com/problems/minimize-xor/description/
pub fn minimize_xor(num1: i32, num2: i32) -> i32 {
    let num1_bits = num1.count_ones();
    let num2_bits = num2.count_ones();
    let mut answer = num1;
    if num1_bits > num2_bits {
        for _ in 0..=num1_bits - num2_bits {
            answer &= answer - 1;
        }
    } else if num1_bits < num2_bits {
        answer = 0;
        for i in 0..=num2_bits - num1_bits {
            answer |= 1 << i;
        }
    }
    answer
}

fn main() {
    // println!("{}", minimize_xor(3, 5)); // 3
    // println!("{}", minimize_xor(1, 12)); // 3
    println!("{}", minimize_xor(25, 72)); // 24
}
