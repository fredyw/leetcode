// https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/
pub fn max_operations(s: String) -> i32 {
    let mut answer = 0;
    let mut one_idx = s.len(); // initial value
    let bytes = s.as_bytes();
    for i in (0..bytes.len()).rev() {
        if bytes[i] == b'1' && one_idx == s.len() {
            one_idx = i;
        } else if bytes[i] == b'1' {
            answer += (one_idx - i) as i32 - 1;
            one_idx -= 1;
        }
    }
    answer
}

fn main() {
    println!("{}", max_operations("1001101".to_string())); // 4
    println!("{}", max_operations("00111".to_string())); // 0
}
