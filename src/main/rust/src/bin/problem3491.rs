// https://leetcode.com/problems/phone-number-prefix/description/
pub fn phone_prefix(mut numbers: Vec<String>) -> bool {
    numbers.sort();
    for i in 0..numbers.len() - 1 {
        if numbers[i + 1].starts_with(&numbers[i]) {
            return false;
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
