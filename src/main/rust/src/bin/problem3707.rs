// https://leetcode.com/problems/equal-score-substrings/description/
pub fn score_balance(s: String) -> bool {
    let mut prefix_sum: Vec<i32> = vec![];
    let mut total_sum = 0;
    for (i, c) in s.chars().enumerate() {
        let value = c as i32 - 'a' as i32 + 1;
        prefix_sum.push(if i == 0 {
            value
        } else {
            prefix_sum[i - 1] + value
        });
        total_sum += value;
    }
    for i in 0..s.len() {
        let left_sum = prefix_sum[i];
        let right_sum = total_sum - prefix_sum[i];
        if left_sum == right_sum {
            return true;
        }
    }
    false
}

fn main() {
    println!("{}", score_balance("adcb".to_string())); // true
    println!("{}", score_balance("bace".to_string())); // false
}
