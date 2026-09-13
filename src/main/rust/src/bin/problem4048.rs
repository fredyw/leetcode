use std::collections::HashMap;

// https://leetcode.com/problems/count-values-with-equally-spaced-occurrences-i/description/
pub fn count_special_integers(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, Vec<usize>> = HashMap::new();
    for (i, num) in nums.iter().enumerate() {
        map.entry(*num).or_insert_with(Vec::new).push(i);
    }
    let map: HashMap<i32, Vec<usize>> = map
        .into_iter()
        .filter(|(_, indices)| indices.len() == 3)
        .collect::<HashMap<_, _>>();
    let mut answer = 0;
    for (_, indices) in map {
        answer += if indices[1] - indices[0] == indices[2] - indices[1] {
            1
        } else {
            0
        };
    }
    answer
}

fn main() {
    println!("{}", count_special_integers(vec![1, 8, 1, 5, 1, 5, 8, 5])); // 2
    println!("{}", count_special_integers(vec![8, 8, 8, 8])); // 0
    println!("{}", count_special_integers(vec![8, 6, 6, 8, 8])); // 0
}
