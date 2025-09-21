// https://leetcode.com/problems/process-string-with-special-operations-i/description/
pub fn process_str(s: String) -> String {
    let mut answer = String::new();
    for c in s.chars() {
        match c {
            '*' => {
                if !answer.is_empty() {
                    answer.remove(answer.len() - 1);
                }
            }
            '#' => answer.push_str(&answer.clone()),
            '%' => answer = answer.chars().rev().collect(),
            _ => answer.push(c),
        }
    }
    answer
}

fn main() {
    println!("{}", process_str("a#b%*".to_string())); // "ba"
    println!("{}", process_str("z*#".to_string())); // ""
}
