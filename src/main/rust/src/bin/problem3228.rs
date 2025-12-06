// https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/
pub fn max_operations(s: String) -> i32 {
    let mut answer = 0;
    let mut one_idx = s.len(); // initial value
    for (i, char) in s.chars().rev().enumerate() {
        println!("index: {i}");
        if one_idx == s.len() {
            one_idx = i;
        } else {
            answer += (one_idx - i) as i32 - 1;
            one_idx = i;
        }
    }
    answer
}

fn main() {
    println!("{}", max_operations("1001101".to_string())); // 4
    println!("{}", max_operations("00111".to_string())); // 0
}
