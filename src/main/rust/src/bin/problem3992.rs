use std::collections::HashMap;

// https://leetcode.com/problems/rearrange-string-to-avoid-character-pair/description/
pub fn rearrange_string(s: String, x: char, y: char) -> String {
    let mut x_count = 0;
    let mut y_count = 0;
    let mut rest_counts: HashMap<char, i32> = HashMap::new();
    for c in s.chars() {
        if c == x {
            x_count += 1;
        } else if c == y {
            y_count += 1;
        } else {
            *rest_counts.entry(c).or_insert(0) += 1;
        }
    }
    let mut answer = String::new();
    for _ in 0..y_count {
        answer.push(y);
    }
    for (char, count) in rest_counts.iter() {
        for _ in 0..*count {
            answer.push(*char);
        }
    }
    for _ in 0..x_count {
        answer.push(x);
    }
    answer
}

fn main() {
    println!("{}", rearrange_string("aabc".to_string(), 'a', 'c')); // "cbaa"
    println!("{}", rearrange_string("dcab".to_string(), 'd', 'b')); // "cabd"
    println!("{}", rearrange_string("axe".to_string(), 'o', 'x')); // "axe"
}
