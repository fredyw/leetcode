use std::collections::HashMap;

// https://leetcode.com/problems/count-pairs-of-equal-substrings-with-minimum-difference/description/
pub fn count_quadruples(first_string: String, second_string: String) -> i32 {
    let first_string = first_string.as_bytes();
    let second_string = second_string.as_bytes();
    let mut char_to_index_map: HashMap<u8, usize> = HashMap::new();
    for i in 0..second_string.len() {
        if !char_to_index_map.contains_key(&second_string[i]) {
            char_to_index_map.insert(second_string[i], i);
        }
    }
    let mut count_diffs: HashMap<i32, i32> = HashMap::new();
    for i in 0..first_string.len() {
        if let Some(j) = char_to_index_map.get(&first_string[i]) {
            let diff = i as i32 - *j as i32;
            *count_diffs.entry(diff).or_insert(0) += 1;
        }
    }
    if let Some((_, count)) = count_diffs.iter().min() {
        *count
    } else {
        0
    }
}

fn main() {
    println!(
        "{}",
        count_quadruples("abcd".to_string(), "bccda".to_string())
    ); // 1
    println!("{}", count_quadruples("ab".to_string(), "cd".to_string())); // 0
    println!("{}", count_quadruples("aa".to_string(), "aa".to_string())); // 1
    println!("{}", count_quadruples("aa".to_string(), "aa".to_string())); // 1
    println!("{}", count_quadruples("aa".to_string(), "aaa".to_string())); // 1
    println!(
        "{}",
        count_quadruples("dwtgmqucavlta".to_string(), "gupciaqadwtgm".to_string())
    ); // 5
}
