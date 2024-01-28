use std::collections::HashMap;

// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/description/
pub fn minimum_pushes(word: String) -> i32 {
    let bytes = word.as_bytes();
    let mut map: HashMap<u8, i32> = HashMap::new();
    for byte in bytes.iter() {
        *map.entry(*byte).or_insert(0) += 1;
    }
    let mut v: Vec<(i32, u8)> = map.iter().map(|(k, v)| (*v, *k)).collect();
    v.sort_by(|a, b| b.cmp(a));
    let mut answer = 0;
    let mut num_press = 1;
    let mut i = 0;
    for (count, _) in v.iter() {
        if i != 0 && i % 8 == 0 {
            num_press += 1;
        }
        answer += count * num_press;
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", minimum_pushes("abcde".to_string())); // 5
    println!("{}", minimum_pushes("xyzxyzxyzxyz".to_string())); // 12
    println!("{}", minimum_pushes("aabbccddeeffgghhiiiiii".to_string())); // 24
}
