use std::collections::HashMap;

// https://leetcode.com/problems/group-shifted-strings/description/
pub fn group_strings(strings: Vec<String>) -> Vec<Vec<String>> {
    let mut map: HashMap<String, Vec<String>> = HashMap::new();
    for string in strings.iter() {
        let mut diff = 0;
        let mut s = String::new();
        for (i, char) in string.chars().enumerate() {
            if i == 0 {
                if char == 'a' {
                    s = string.to_owned();
                    break;
                }
                diff = (char as i32 - 'a' as i32).abs();
            }
            let n = char as i32 - ('a' as i32 + diff);
            if n < 0 {
                s.push((('z' as i32 + n + 1) as u8) as char);
            } else {
                s.push((char as u8 - diff as u8) as char);
            }
        }
        map.entry(s).or_insert(vec![]).push(string.to_owned());
    }
    let mut answer = vec![];
    for (_, value) in map.into_iter() {
        answer.push(value);
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        group_strings(vec![
            "abc".to_string(),
            "bcd".to_string(),
            "acef".to_string(),
            "xyz".to_string(),
            "az".to_string(),
            "ba".to_string(),
            "a".to_string(),
            "z".to_string()
        ])
    ); // [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
    println!("{:?}", group_strings(vec!["a".to_string(),])); // [["a"]]
}
