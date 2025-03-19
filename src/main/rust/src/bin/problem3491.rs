// https://leetcode.com/problems/phone-number-prefix/description/
pub fn phone_prefix(numbers: Vec<String>) -> bool {
    for (i, num1) in numbers.iter().enumerate() {
        for (j, num2) in numbers.iter().enumerate() {
            if i == j {
                continue;
            }
            if num1.starts_with(num2) {
                return false;
            }
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        phone_prefix(vec![
            "1".to_string(),
            "2".to_string(),
            "4".to_string(),
            "3".to_string()
        ])
    ); // true
    println!(
        "{}",
        phone_prefix(vec![
            "001".to_string(),
            "007".to_string(),
            "15".to_string(),
            "00153".to_string()
        ])
    ); // false
    println!(
        "{}",
        phone_prefix(vec![
            "007".to_string(),
            "15".to_string(),
            "00153".to_string(),
            "001".to_string()
        ])
    ); // false
    println!("{}", phone_prefix(vec!["1".to_string(), "1".to_string()])); // false
}
