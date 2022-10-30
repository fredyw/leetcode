use std::collections::HashMap;

// https://leetcode.com/problems/odd-string-difference/
pub fn odd_string(words: Vec<String>) -> String {
    let mut map: HashMap<String, (String, i32)> = HashMap::new();
    for word in words.iter() {
        let bytes = word.as_bytes();
        let mut v = vec![0; words.len() - 1];
        for i in 1..bytes.len() {
            let diff = bytes[i] as i32 - bytes[i - 1] as i32;
            v[i - 1] = diff;
        }
        let key = format!("{:?}", v);
        let entry = map.entry(key).or_insert((word.clone(), 0));
        entry.1 += 1;
    }
    map.into_iter()
        .filter(|e| e.1 .1 == 1)
        .map(|e| e.1 .0)
        .last()
        .unwrap()
}

fn main() {
    println!(
        "{}",
        odd_string(vec![
            "adc".to_string(),
            "wzy".to_string(),
            "abc".to_string()
        ])
    ); // "abc"
    println!(
        "{}",
        odd_string(vec![
            "aaa".to_string(),
            "bob".to_string(),
            "ccc".to_string(),
            "ddd".to_string()
        ])
    ); // "bob"
}
