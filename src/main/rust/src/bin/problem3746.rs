// https://leetcode.com/problems/minimum-string-length-after-balanced-removals/description/
pub fn min_length_after_removals(s: String) -> i32 {
    let mut a_count = 0;
    let mut b_count = 0;
    for char in s.chars() {
        if char == 'a' {
            a_count += 1;
        } else {
            b_count += 1;
        }
    }
    s.len() as i32 - (a_count.min(b_count) * 2)
}

fn main() {
    println!("{}", min_length_after_removals("aabbab".to_string())); // 0
    println!("{}", min_length_after_removals("aaaa".to_string())); // 4
    println!("{}", min_length_after_removals("aaabb".to_string())); // 1
}
