use std::collections::BTreeMap;

// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
pub fn number_of_weak_characters(mut properties: Vec<Vec<i32>>) -> i32 {
    let mut map: BTreeMap<i32, Vec<i32>> = BTreeMap::new();
    for prop in properties.iter() {
        map.entry(prop[0]).or_insert(vec![]).push(prop[1]);
    }
    let mut suffix_defense = vec![0; map.len()];
    for (i, (_, defenses)) in map.iter().enumerate().rev() {
        let max_defense = defenses.iter().max().unwrap();
        if i == map.len() - 1 {
            suffix_defense[i] = *max_defense;
        } else {
            suffix_defense[i] = *max_defense.max(&suffix_defense[i + 1]);
        }
    }
    let mut answer = 0;
    for (i, (_, defenses)) in map.iter().enumerate() {
        for defense in defenses.iter() {
            if i + 1 < map.len() && *defense < suffix_defense[i + 1] {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        number_of_weak_characters(vec![vec![5, 5], vec![6, 3], vec![3, 6]])
    ); // 0
    println!(
        "{}",
        number_of_weak_characters(vec![vec![2, 2], vec![3, 3]])
    ); // 1
    println!(
        "{}",
        number_of_weak_characters(vec![vec![1, 5], vec![10, 4], vec![4, 3]])
    ); // 1
    println!(
        "{}",
        number_of_weak_characters(vec![vec![1, 5], vec![10, 4], vec![4, 3], vec![5, 5]])
    ); // 1
    println!(
        "{}",
        number_of_weak_characters(vec![
            vec![7, 9],
            vec![10, 7],
            vec![6, 9],
            vec![10, 4],
            vec![7, 5],
            vec![7, 10]
        ])
    ); // 2
}
