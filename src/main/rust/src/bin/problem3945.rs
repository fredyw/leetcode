use itertools::Itertools;

// https://leetcode.com/problems/digit-frequency-score/description/
pub fn digit_frequency_score(n: i32) -> i32 {
    n.to_string()
        .chars()
        .counts()
        .into_iter()
        .fold(0, |acc, (char, count)| {
            let digit = char.to_digit(10).unwrap() as i32;
            acc + (digit * count as i32)
        })
}

fn main() {
    println!("{}", digit_frequency_score(122)); // 5
    println!("{}", digit_frequency_score(101)); // 2
}
