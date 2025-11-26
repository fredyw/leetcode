use std::collections::HashMap;

// https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/
pub fn minimum_distance(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, Vec<usize>> = HashMap::new();
    for (i, n) in nums.iter().enumerate() {
        map.entry(*n).or_insert(Vec::new()).push(i);
    }
    let mut answer = 0;
    for (_, v) in map.iter() {
        if v.len() >= 3 {
            let i = v[0] as i32;
            let j = v[v.len() / 2] as i32;
            let k = v[v.len() - 1] as i32;
            let distance = (i - j).abs() + (j - k).abs() + (k - i).abs();
            answer = answer.max(distance);
        }
    }
    answer
}

fn main() {
    println!("{}", minimum_distance(vec![1, 2, 1, 1, 3])); // 6
    println!("{}", minimum_distance(vec![1, 1, 2, 3, 2, 1, 2])); // 8
    println!("{}", minimum_distance(vec![1])); // -1
    println!("{}", minimum_distance(vec![1, 1, 2, 3, 2, 1, 1, 1])); // 8
}
