// https://leetcode.com/problems/count-substrings-that-satisfy-k-constraint-i/description/
pub fn count_k_constraint_substrings(s: String, k: i32) -> i32 {
    let mut num_zeros = 0;
    let mut num_ones = 0;
    let mut answer = 0;
    let chars: Vec<char> = s.chars().collect();
    let mut i = 0;
    let mut j = 0;
    while i < chars.len() {
        if chars[i] == '0' {
            num_zeros += 1;
        } else {
            num_ones += 1;
        }
        if num_zeros > k && num_ones > k {
            if chars[j] == '0' {
                num_zeros -= 1;
            } else {
                num_ones -= 1;
            }
            j += 1;
        }
        answer += i as i32 - j as i32 + 1;
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", count_k_constraint_substrings("10101".to_string(), 1)); // 12
    println!(
        "{}",
        count_k_constraint_substrings("1010101".to_string(), 2)
    ); // 25
    println!("{}", count_k_constraint_substrings("11111".to_string(), 1)); // 15
    println!(
        "{}",
        count_k_constraint_substrings("101001010100101111010101".to_string(), 4)
    ); // 200
}
