// https://leetcode.com/problems/minimum-operations-to-transform-string/description/
pub fn min_operations(s: String) -> i32 {
    let mut answer = 0;
    let mut chars: Vec<bool> = vec![false; 26];
    for c in s.chars() {
        if c != 'a' {
            if !chars[c as usize - 'a' as usize] {
                answer += 1;
            }
            chars[c as usize - 'a' as usize] = true;
        }
    }
    answer
}

fn main() {
    println!("{}", min_operations(String::from("yz"))); // 2
    println!("{}", min_operations(String::from("a"))); // 0
    println!("{}", min_operations(String::from("b"))); // 25
    println!("{}", min_operations(String::from("bz"))); // 25
}
