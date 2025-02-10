use std::collections::HashMap;

// https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/description/
pub fn maximum_length(s: String) -> i32 {
    let mut map: HashMap<&[u8], i32> = HashMap::new();
    let bytes = s.as_bytes();
    for i in 0..bytes.len() {
        for j in i..bytes.len() {
            let sub = &bytes[i..=j];
            println!("{:?}", sub);
        }
    }
    0
}

fn main() {
    println!("{}", maximum_length("aaaa".to_string())); // 2
                                                        // println!("{}", maximum_length("abcdef".to_string())); // -1
                                                        // println!("{}", maximum_length("abcaba".to_string())); // 1
}
