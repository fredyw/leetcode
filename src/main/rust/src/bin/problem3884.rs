// https://leetcode.com/problems/first-matching-character-from-both-ends/description/
pub fn first_matching_index(s: String) -> i32 {
    let bytes = s.as_bytes();
    for i in 0..=bytes.len() / 2 {
        if bytes[i] == bytes[bytes.len() - i - 1] {
            return i as i32;
        }
    }
    -1
}

fn main() {
    println!("{}", first_matching_index("abcacbd".to_string())); // 1
    println!("{}", first_matching_index("abc".to_string())); // 1
    println!("{}", first_matching_index("abcdab".to_string())); // -1
}
