// https://leetcode.com/problems/minimum-operations-to-transform-string/description/
pub fn min_operations(s: String) -> i32 {
    let mut answer = 0;
    let mut chars = s.chars().collect::<Vec<char>>();
    chars.sort_unstable();
    for i in 0..chars.len() - 1 {
        if chars[i] == 'a' || chars[i] == chars[i + 1] {
            continue;
        }
        answer += chars[i + 1] as i32 - chars[i] as i32;
    }
    if chars[chars.len() - 1] != 'a' {
        answer += 'z' as i32 - chars[chars.len() - 1] as i32 + 1;
    }
    answer
}

fn main() {
    println!("{}", min_operations(String::from("yz"))); // 2
    println!("{}", min_operations(String::from("a"))); // 0
    println!("{}", min_operations(String::from("b"))); // 25
    println!("{}", min_operations(String::from("bz"))); // 25
}
