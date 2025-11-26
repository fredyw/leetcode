use std::collections::HashMap;

// https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/
pub fn minimum_distance(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, Vec<usize>> = HashMap::new();
    for (i, n) in nums.iter().enumerate() {
        map.entry(*n).or_insert(Vec::new()).push(i);
    }
    let mut answer = i32::MAX;
    for (_, v) in map.iter() {
        if v.len() < 3 {
            continue;
        }
        for index in 0..v.len() - 2 {
            let i = v[index] as i32;
            let j = v[index + 1] as i32;
            let k = v[index + 2] as i32;
            let distance = (i - j).abs() + (j - k).abs() + (k - i).abs();
            answer = answer.min(distance);
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", minimum_distance(vec![1, 2, 1, 1, 3])); // 6
    println!("{}", minimum_distance(vec![1, 1, 2, 3, 2, 1, 2])); // 8
    println!("{}", minimum_distance(vec![1])); // -1
    println!("{}", minimum_distance(vec![1, 1, 2, 3, 2, 1, 1, 1])); // 4
}
