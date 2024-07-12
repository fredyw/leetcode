use std::collections::HashMap;

// https://leetcode.com/problems/longest-common-subsequence-between-sorted-arrays/description/
pub fn longest_common_subsequence(arrays: Vec<Vec<i32>>) -> Vec<i32> {
    let mut map: HashMap<i32, i32> = HashMap::new();
    for array in arrays.iter() {
        for n in array.iter() {
            *map.entry(*n).or_insert(0) += 1;
        }
    }
    let mut answer = vec![];
    for n in arrays[0].iter() {
        if let Some(count) = map.get(&n) {
            if *count == arrays.len() as i32 {
                answer.push(*n);
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        longest_common_subsequence(vec![vec![1, 3, 4], vec![1, 4, 7, 9]])
    ); // [1,4]
    println!(
        "{:?}",
        longest_common_subsequence(vec![
            vec![2, 3, 6, 8],
            vec![1, 2, 3, 5, 6, 7, 10],
            vec![2, 3, 4, 6, 9]
        ])
    ); // [2,3,6]
    println!(
        "{:?}",
        longest_common_subsequence(vec![vec![1, 2, 3, 4, 5], vec![6, 7, 8]])
    ); // []
}
