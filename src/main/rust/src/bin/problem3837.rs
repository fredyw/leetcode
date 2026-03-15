use std::collections::HashMap;

// https://leetcode.com/problems/delayed-count-of-equal-elements/description/
pub fn delayed_count(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut answer = vec![0; nums.len()];
    let k = k as usize;
    let mut map: HashMap<i32, i32> = HashMap::new();
    for i in k + 1..nums.len() {
        *map.entry(nums[i]).or_insert(0) += 1;
    }
    let mut i = 0;
    while i + k + 1 < nums.len() {
        if let Some(count) = map.get(&nums[i]) {
            answer[i] = *count;
        }
        if let Some(count) = map.get_mut(&nums[i + k + 1]) {
            *count -= 1;
            if *count == 0 {
                map.remove(&nums[i + k + 1]);
            }
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{:?}", delayed_count(vec![1, 2, 1, 1], 1)); // [2,0,0,0]
    println!("{:?}", delayed_count(vec![3, 1, 3, 1], 0)); // [1,1,0,0]
    println!("{:?}", delayed_count(vec![1, 2, 1, 1, 1], 1)); // [3,0,1,0,0]
    println!("{:?}", delayed_count(vec![1, 2, 1, 1, 1], 0)); // [3,0,2,1,0]
}
