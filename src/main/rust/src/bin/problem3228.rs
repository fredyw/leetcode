// https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/
pub fn max_operations(s: String) -> i32 {
    let mut answer = 0;
    let bytes = s.as_bytes();
    let mut count = 0;
    for i in 0..s.bytes().len() - 1 {
        if bytes[i] == b'1' && bytes[i + 1] == b'1' {
            count += 1;
        } else if bytes[i] == b'0' && bytes[i + 1] == b'1' {
            count = 1;
        } else if bytes[i] == b'1' && bytes[i + 1] == b'0' {
            answer += count;
            count = 1;
        }
    }
    answer
}

fn main() {
    println!("{}", max_operations("1001101".to_string())); // 4
    println!("{}", max_operations("00111".to_string())); // 0
    println!("{}", max_operations("111000111000111".to_string())); // 9
}
