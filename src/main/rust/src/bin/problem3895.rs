// https://leetcode.com/problems/count-digit-appearances/description/
pub fn count_digit_occurrences(nums: Vec<i32>, digit: i32) -> i32 {
    let mut answer = 0;
    for num in &nums {
        for c in num.to_string().chars() {
            if c == std::char::from_digit(digit as u32, 10).unwrap() {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_digit_occurrences(vec![12, 54, 32, 22], 2)); // 4
    println!("{}", count_digit_occurrences(vec![1, 34, 7], 9)); // 0
}
