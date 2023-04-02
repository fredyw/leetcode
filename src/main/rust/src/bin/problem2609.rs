// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string/
pub fn find_the_longest_balanced_substring(s: String) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        find_the_longest_balanced_substring("01000111".to_string())
    ); // 6
    println!(
        "{}",
        find_the_longest_balanced_substring("00111".to_string())
    ); // 4
    println!("{}", find_the_longest_balanced_substring("111".to_string())); // 0
}
