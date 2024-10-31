use std::collections::HashMap;

// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
pub fn length_of_longest_substring_two_distinct(s: String) -> i32 {
    let mut answer = 0;
    let bytes = s.as_bytes();
    let mut map: HashMap<u8, i32> = HashMap::new();
    let mut i = 0;
    let mut j = 0;
    while i < s.len() {
        *map.entry(bytes[i]).or_insert(0) += 1;
        while map.len() > 2 {
            let count = map.get_mut(&bytes[j]).unwrap();
            if *count - 1 == 0 {
                map.remove(&bytes[j]);
            } else {
                *count -= 1;
            }
            j += 1;
        }
        answer = answer.max((i - j) as i32 + 1);
        i += 1;
    }
    answer
}

fn main() {
    println!(
        "{}",
        length_of_longest_substring_two_distinct("eceba".to_string())
    ); // 3
    println!(
        "{}",
        length_of_longest_substring_two_distinct("ccaabbb".to_string())
    ); // 5
}
