// https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/
pub fn maximum_value(strs: Vec<String>) -> i32 {
    let mut answer = 0;
    for s in strs.iter() {
        let digit: String = s.chars().into_iter().filter(|c| c.is_digit(10)).collect();
        if digit.len() != s.len() {
            answer = answer.max(s.len() as i32);
        } else {
            answer = answer.max(digit.parse::<i32>().unwrap());
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        maximum_value(vec![
            "alic3".to_string(),
            "bob".to_string(),
            "3".to_string(),
            "4".to_string(),
            "00000".to_string()
        ])
    ); // 5
    println!(
        "{}",
        maximum_value(vec![
            "1".to_string(),
            "01".to_string(),
            "001".to_string(),
            "0001".to_string()
        ])
    ); // 1
}
