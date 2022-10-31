use std::collections::HashSet;

// https://leetcode.com/problems/words-within-two-edits-of-dictionary/
pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
    let mut answer: Vec<String> = vec![];
    let dictionary: HashSet<String> = dictionary.into_iter().collect();
    'outer: for query in queries.iter() {
        if dictionary.contains(query) {
            answer.push(query.clone());
            continue;
        }
        let mut bytes: Vec<u8> = query.as_bytes().into_iter().map(|a| *a).collect();
        for i in 0..bytes.len() {
            let tmp1 = bytes[i];
            for j in 0..26 {
                bytes[i] = j as u8 + 'a' as u8;
                let s = String::from_utf8(bytes.clone()).unwrap();
                if dictionary.contains(&s) {
                    answer.push(query.clone());
                    continue 'outer;
                }
                for k in i + 1..bytes.len() {
                    let tmp2 = bytes[k];
                    for l in 0..26 {
                        bytes[k] = l as u8 + 'a' as u8;
                        let s = String::from_utf8(bytes.clone()).unwrap();
                        if dictionary.contains(&s) {
                            answer.push(query.clone());
                            continue 'outer;
                        }
                    }
                    bytes[k] = tmp2;
                }
            }
            bytes[i] = tmp1;
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        two_edit_words(
            vec![
                "word".to_string(),
                "note".to_string(),
                "ants".to_string(),
                "wood".to_string()
            ],
            vec!["wood".to_string(), "joke".to_string(), "moat".to_string()]
        )
    ); // ["word","note","wood"]
    println!(
        "{:?}",
        two_edit_words(vec!["yes".to_string()], vec!["not".to_string()])
    ); // []
}
