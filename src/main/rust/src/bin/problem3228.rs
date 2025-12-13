// https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/
pub fn max_operations(s: String) -> i32 {
    let s = if let Some(i) = s.rfind(|c| c != '1') {
        &s[0..=i]
    } else {
        ""
    };
    let mut answer = 0;
    let mut count = 0;
    for x in s.split('0') {
        if !x.is_empty() {
            count += x.len() as i32;
            answer += count;
        }
    }
    answer
}

fn main() {
    println!("{}", max_operations("1001101".to_string())); // 4
    println!("{}", max_operations("00111".to_string())); // 0
    println!("{}", max_operations("111000111000111".to_string())); // 9
    println!("{}", max_operations("10011011101".to_string())); // 10
    println!("{}", max_operations("10".to_string())); // 1
    println!("{}", max_operations("0000".to_string())); // 0
}
