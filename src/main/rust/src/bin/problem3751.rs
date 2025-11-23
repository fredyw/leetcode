// https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/
pub fn total_waviness(num1: i32, num2: i32) -> i32 {
    let mut answer = 0;
    for num in num1..=num2 {
        let s = num.to_string();
        let bytes = s.as_bytes();
        for i in 1..bytes.len() - 1 {
            if bytes[i - 1] > bytes[i] && bytes[i + 1] > bytes[i] {
                answer += 1;
            } else if bytes[i - 1] < bytes[i] && bytes[i + 1] < bytes[i] {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", total_waviness(120, 130)); // 3
    println!("{}", total_waviness(198, 202)); // 3
    println!("{}", total_waviness(4848, 4848)); // 2
}
