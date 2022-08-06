use std::collections::HashMap;

// https://leetcode.com/problems/merge-similar-items/
pub fn merge_similar_items(items1: Vec<Vec<i32>>, items2: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for item1 in items1.into_iter() {
        map.insert(item1[0], item1[1]);
    }
    for item2 in items2.into_iter() {
        match map.get(&item2[0]) {
            Some(weight) => {
                map.insert(item2[0], *weight + item2[1]);
            }
            None => {
                map.insert(item2[0], item2[1]);
            }
        }
    }
    let mut answer: Vec<Vec<i32>> = map.into_iter().map(|a| vec![a.0, a.1]).collect();
    answer.sort();
    answer
}

fn main() {
    println!(
        "{:?}",
        merge_similar_items(
            vec![vec![1, 1], vec![4, 5], vec![3, 8]],
            vec![vec![3, 1], vec![1, 5]]
        )
    ); // [[1,6],[3,9],[4,5]]
    println!(
        "{:?}",
        merge_similar_items(
            vec![vec![1, 1], vec![3, 2], vec![2, 3]],
            vec![vec![2, 1], vec![3, 2], vec![1, 3]]
        )
    ); // [[1,4],[2,4],[3,4]]
    println!(
        "{:?}",
        merge_similar_items(
            vec![vec![1, 3], vec![2, 2]],
            vec![vec![7, 1], vec![2, 2], vec![1, 4]]
        )
    ); // [[1,7],[2,4],[7,1]]
}
