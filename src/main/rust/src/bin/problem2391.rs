use std::collections::HashMap;

// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
pub fn garbage_collection(garbage: Vec<String>, travel: Vec<i32>) -> i32 {
    fn garbage_map(garbage: String) -> HashMap<char, i32> {
        let mut map: HashMap<char, i32> = HashMap::new();
        let chars: Vec<char> = garbage.chars().collect();
        for c in chars.into_iter() {
            *map.entry(c).or_insert(0) += 1;
        }
        map
    }

    let mut garbage_vec: Vec<HashMap<char, i32>> = vec![];
    let mut metal_time = 0;
    let mut paper_time = 0;
    let mut glass_time = 0;
    let mut metal_last_index = 0;
    let mut paper_last_index = 0;
    let mut glass_last_index = 0;
    for (i, g) in garbage.into_iter().enumerate() {
        let map = garbage_map(g);
        if let Some(count) = map.get(&'M') {
            metal_time += count;
            metal_last_index = i;
        }
        if let Some(count) = map.get(&'P') {
            paper_time += count;
            paper_last_index = i;
        }
        if let Some(count) = map.get(&'G') {
            glass_time += count;
            glass_last_index = i;
        }
        garbage_vec.push(map);
    }
    for i in 0..garbage_vec.len() {
        if i == 0 {
            continue;
        }
        if metal_last_index >= i {
            metal_time += travel[i - 1];
        }
        if paper_last_index >= i {
            paper_time += travel[i - 1];
        }
        if glass_last_index >= i {
            glass_time += travel[i - 1];
        }
    }
    metal_time + paper_time + glass_time
}

fn main() {
    println!(
        "{}",
        garbage_collection(
            vec![
                "G".to_string(),
                "P".to_string(),
                "GP".to_string(),
                "GG".to_string()
            ],
            vec![2, 4, 3]
        )
    ); // 21
    println!(
        "{}",
        garbage_collection(
            vec!["MMM".to_string(), "PGM".to_string(), "GP".to_string()],
            vec![3, 10]
        )
    ); // 37
}
