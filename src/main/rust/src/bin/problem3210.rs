// https://leetcode.com/problems/find-the-encrypted-string/description/
pub fn get_encrypted_string(s: String, k: i32) -> String {
    let mut answer = String::new();
    let chars: Vec<char> = s.chars().collect();
    for i in 0..chars.len() {
        let j = (i + k as usize) % chars.len();
        answer.push(chars[j]);
    }
    answer
}

fn main() {
    println!("{}", get_encrypted_string("dart".to_string(), 3)); // "tdar"
    println!("{}", get_encrypted_string("aaa".to_string(), 1)); // "aaa"
}
