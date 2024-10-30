// https://leetcode.com/problems/ternary-expression-parser/description/
pub fn parse_ternary(expression: String) -> String {
    let expression: Vec<char> = expression.chars().collect();
    todo!()
}

fn main() {
    println!("{}", parse_ternary("T?2:3".to_string())); // "2"
    println!("{}", parse_ternary("F?1:T?4:5".to_string())); // "4"
    println!("{}", parse_ternary("T?T?F:5:3".to_string())); // "F"
    println!("{}", parse_ternary("T?T?T:T:F".to_string())); // "T"
}
