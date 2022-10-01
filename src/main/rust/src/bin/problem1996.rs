use std::collections::BTreeMap;

// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
pub fn number_of_weak_characters(properties: Vec<Vec<i32>>) -> i32 {
    let mut map: BTreeMap<i32, Vec<i32>> = BTreeMap::new();
    for prop in properties.iter() {
        map.entry(prop[0]).or_insert(vec![]).push(prop[1]);
    }
    let mut answer = 0;
    let mut max = 0;
    for (i, (_, defenses)) in map.iter().enumerate().rev() {
        if i == map.len() - 1 {
            max = *defenses.iter().max().unwrap();
        } else {
            let mut tmp_max = 0;
            for defense in defenses.iter() {
                if *defense < max {
                    answer += 1;
                }
                tmp_max = tmp_max.max(*defense);
            }
            max = max.max(tmp_max);
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
