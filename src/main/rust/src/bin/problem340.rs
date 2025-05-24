use std::collections::HashMap;

// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
pub fn length_of_longest_substring_k_distinct(s: String, k: i32) -> i32 {
    let bytes = s.as_bytes();
    let mut map: HashMap<u8, usize> = HashMap::new();
    let mut answer = 0;
    let mut j = 0;
    for i in 0..bytes.len() {
        map.insert(bytes[i], i);
        if map.len() > k as usize {
            if let Some(&mut index) = map.get_mut(&bytes[j]) {
                map.remove(&bytes[j]);
                j = index + 1;
            }
        }
        answer = answer.max(i as i32 - j as i32 + 1);
    }
    answer
}

fn main() {
    // println!(
    //     "{}",
    //     length_of_longest_substring_k_distinct("eceba".to_string(), 2)
    // ); // 3
    // println!(
    //     "{}",
    //     length_of_longest_substring_k_distinct("aa".to_string(), 1)
    // ); // 2
    // println!(
    //     "{}",
    //     length_of_longest_substring_k_distinct("abaccc".to_string(), 2)
    // ); // 4
    println!(
        "{}",
        length_of_longest_substring_k_distinct("aabaaccccccccc".to_string(), 2)
    ); // 11
       // println!(
       //     "{}",
       //     length_of_longest_substring_k_distinct("a".to_string(), 0)
       // ); // 0
       // println!(
       //     "{}",
       //     length_of_longest_substring_k_distinct("ab".to_string(), 1)
       // ); // 1
       // println!(
       //     "{}",
       //     length_of_longest_substring_k_distinct("aab".to_string(), 1)
       // ); // 2
       // println!(
       //     "{}",
       //     length_of_longest_substring_k_distinct("abc".to_string(), 2)
       // ); // 2
       // println!(
       //     "{}",
       //     length_of_longest_substring_k_distinct("abc".to_string(), 3)
       // ); // 3
}
