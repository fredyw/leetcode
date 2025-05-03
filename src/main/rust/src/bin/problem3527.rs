use std::cmp::Ordering;
use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/find-the-most-common-response/
pub fn find_common_response(responses: Vec<Vec<String>>) -> String {
    let responses: Vec<HashSet<String>> = responses
        .into_iter()
        .map(|v| v.into_iter().collect::<HashSet<String>>())
        .collect();
    let mut map: HashMap<String, u32> = HashMap::new();
    for response in responses {
        for r in response {
            *map.entry(r).or_insert(0) += 1;
        }
    }
    let mut v: Vec<(String, u32)> = map.into_iter().collect();
    v.sort_by(|a, b| {
        let ord = b.1.cmp(&a.1);
        if ord == Ordering::Equal {
            a.0.cmp(&b.0)
        } else {
            ord
        }
    });
    v[0].0.to_string()
}

fn main() {
    println!(
        "{}",
        find_common_response(vec![
            vec![
                "good".to_string(),
                "ok".to_string(),
                "good".to_string(),
                "ok".to_string()
            ],
            vec![
                "ok".to_string(),
                "bad".to_string(),
                "good".to_string(),
                "ok".to_string(),
                "ok".to_string()
            ],
            vec!["good".to_string()],
            vec!["bad".to_string()]
        ])
    ); // "good"
    println!(
        "{}",
        find_common_response(vec![
            vec!["good".to_string(), "ok".to_string(), "good".to_string()],
            vec!["ok".to_string(), "bad".to_string()],
            vec!["bad".to_string(), "notsure".to_ascii_lowercase()],
            vec!["great".to_string(), "good".to_string()]
        ])
    ); // "bad"
}
