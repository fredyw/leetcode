// https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/
pub fn maximum_value(strs: Vec<String>) -> i32 {
    todo!()
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
