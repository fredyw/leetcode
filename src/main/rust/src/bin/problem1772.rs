use std::collections::{HashMap, HashSet};

// https://leetcode.com/problems/sort-features-by-popularity/description/
pub fn sort_features(features: Vec<String>, responses: Vec<String>) -> Vec<String> {
    let mut feature_map: HashMap<String, usize> = HashMap::new();
    for (i, feature) in features.into_iter().enumerate() {
        feature_map.insert(feature, i);
    }
    let mut response_set: Vec<HashSet<&str>> = vec![];
    for response in responses.iter() {
        response_set.push(response.split(" ").collect::<HashSet<&str>>());
    }
    let mut map: HashMap<&str, i32> = HashMap::new();
    for (feature, _) in feature_map.iter() {
        map.insert(feature, 0);
    }
    for response in response_set.iter() {
        for s in response {
            if feature_map.contains_key(*s) {
                *map.entry(s).or_insert(0) += 1;
            }
        }
    }
    let mut v: Vec<(&str, i32)> = map.into_iter().map(|(s, c)| (s, c)).collect();
    v.sort_by(|a, b| {
        let cmp = b.1.cmp(&a.1);
        if cmp == std::cmp::Ordering::Equal {
            feature_map
                .get(a.0)
                .unwrap()
                .cmp(feature_map.get(b.0).unwrap())
        } else {
            cmp
        }
    });
    v.into_iter().map(|(s, _)| s.to_owned()).collect()
}

fn main() {
    println!(
        "{:?}",
        sort_features(
            vec![
                "cooler".to_string(),
                "lock".to_string(),
                "touch".to_string()
            ],
            vec![
                "i like cooler cooler".to_string(),
                "lock touch cool".to_string(),
                "locker like touch".to_string()
            ]
        )
    ); // ["touch","cooler","lock"]
    println!(
        "{:?}",
        sort_features(
            vec![
                "a".to_string(),
                "aa".to_string(),
                "b".to_string(),
                "c".to_string()
            ],
            vec![
                "a".to_string(),
                "a aa".to_string(),
                "a a a a a".to_string(),
                "b a".to_string()
            ]
        )
    ); // ["a","aa","b","c"]
}
