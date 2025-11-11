use std::collections::{HashMap, VecDeque};

// https://leetcode.com/problems/minimum-distance-between-three-equal-elements-i/description/
pub fn minimum_distance(nums: Vec<i32>) -> i32 {
    let mut answer = i32::MAX;
    let mut map: HashMap<i32, VecDeque<usize>> = HashMap::new();
    for (i, num) in nums.iter().enumerate() {
        let deque = map.entry(*num).or_default();
        deque.push_back(i);
        if deque.len() == 3 {
            let i = *deque.get(0).unwrap() as i32;
            let j = *deque.get(1).unwrap() as i32;
            let k = *deque.get(2).unwrap() as i32;
            answer = answer.min((i - j).abs() + (j - k).abs() + (k - i).abs());
            deque.pop_front();
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
}
