// https://leetcode.com/problems/number-of-senior-citizens/
pub fn count_seniors(details: Vec<String>) -> i32 {
    details
        .into_iter()
        .filter(|detail| {
            let chars: Vec<char> = detail.chars().collect();
            let age: i32 = format!("{}{}", chars[11], chars[12]).parse().unwrap();
            age > 60
        })
        .count() as i32
}

fn main() {
    println!(
        "{}",
        count_seniors(vec![
            "7868190130M7522".to_string(),
            "5303914400F9211".to_string(),
            "9273338290F4010".to_string()
        ])
    ); // 2
    println!(
        "{}",
        count_seniors(vec![
            "1313579440F2036".to_string(),
            "2921522980M5644".to_string()
        ])
    ); // 0
}
