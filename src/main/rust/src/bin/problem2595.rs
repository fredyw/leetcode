// https://leetcode.com/problems/number-of-even-and-odd-bits/
pub fn even_odd_bit(n: i32) -> Vec<i32> {
    let mut answer: Vec<i32> = vec![0; 2];
    let chars: Vec<char> = format!("{:b}", n).chars().rev().collect();
    for (i, c) in chars.into_iter().enumerate() {
        if i % 2 == 0 {
            if c == '1' {
                answer[0] += 1;
            }
        } else {
            if c == '1' {
                answer[1] += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{:?}", even_odd_bit(17)); // [2, 0]
    println!("{:?}", even_odd_bit(2)); // [0, 1]
}
