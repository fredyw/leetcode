use std::collections::HashMap;

// https://leetcode.com/problems/remove-letter-to-equalize-frequency/
pub fn equal_frequency(word: String) -> bool {
    let mut map1: HashMap<u8, i32> = HashMap::new();
    for b in word.as_bytes().iter() {
        *map1.entry(*b).or_insert(0) += 1;
    }
    if map1.len() == 1 {
        return true;
    }
    let mut map2: HashMap<i32, i32> = HashMap::new();
    for (_, count) in map1.iter() {
        *map2.entry(*count).or_insert(0) += 1;
    }
    if map2.len() == 1 {
        *map2.iter().next().unwrap().0 == 1
    } else if map2.len() == 2 {
        let mut iter = map2.iter();
        let (a, count1) = iter.next().unwrap();
        let (b, count2) = iter.next().unwrap();
        if *count1 > 1 && *count2 > 1 {
            return false;
        }
        i32::abs(a - b) == 1
    } else {
        false
    }
}

fn main() {
    println!("{}", equal_frequency("abcc".to_string())); // true
    println!("{}", equal_frequency("aazz".to_string())); // false
    println!("{}", equal_frequency("bac".to_string())); // true
    println!("{}", equal_frequency("ddaccb".to_string())); // false
    println!("{}", equal_frequency("aca".to_string())); // true
    println!("{}", equal_frequency("zz".to_string())); // true
}
