// https://leetcode.com/problems/minimum-rotations-to-dial-a-number-i/description/
pub fn min_rotations(s: String) -> i32 {
    let mut answer = 0;
    let mut digit = 0;
    for c in s.chars() {
        let mut val1 = ((c as i32 - '0' as i32) - digit) % 10;
        if val1 < 0 {
            val1 += 10;
        }
        let mut val2 = (digit - (c as i32 - '0' as i32)) % 10;
        if val2 < 0 {
            val2 += 10;
        }
        answer += val1.min(val2);
        digit = c as i32 - '0' as i32;
    }
    answer
}

fn main() {
    println!("{}", min_rotations("0192837465".to_string())); // 25
    println!("{}", min_rotations("1200210200".to_string())); // 12
}
