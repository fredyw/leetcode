// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/
pub fn min_changes(s: String) -> i32 {
    let mut answer = 0;
    let bytes = s.as_bytes();
    let mut i = 0;
    while i < bytes.len() {
        if bytes[i] != bytes[i + 1] {
            answer += 1;
        }
        i += 2;
    }
    answer
}

fn main() {
    println!("{}", min_changes("1001".to_string())); // 2
    println!("{}", min_changes("10".to_string())); // 1
    println!("{}", min_changes("0000".to_string())); // 0
    println!("{}", min_changes("10000010".to_string())); // 2
    println!("{}", min_changes("11010110101010".to_string())); // 6
}
