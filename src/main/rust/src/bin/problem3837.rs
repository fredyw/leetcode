use std::collections::HashMap;

// https://leetcode.com/problems/delayed-count-of-equal-elements/description/
pub fn delayed_count(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut map_total_count: HashMap<i32, i32> = HashMap::new();
    for num in &nums {
        *map_total_count.entry(*num).or_insert(0) += 1;
    }
    let mut answer = Vec::with_capacity(nums.len());
    let mut map_count: HashMap<i32, i32> = HashMap::new();
    for i in 0..nums.len() {
        *map_count.entry(nums[i]).or_insert(0) += 1;
        let mut j = i + 1;
        let mut count = 0;
        while j < nums.len() && j < i + (k as usize) + 1 {
            if nums[j] == nums[i] {
                count += 1;
            }
            j += 1;
        }
        answer.push(map_total_count[&nums[i]] - (map_count[&nums[i]] + count));
    }
    answer
}

fn main() {
    println!("{:?}", delayed_count(vec![1, 2, 1, 1], 1)); // [2,0,0,0]
    println!("{:?}", delayed_count(vec![3, 1, 3, 1], 0)); // [1,1,0,0]
    println!("{:?}", delayed_count(vec![1, 2, 1, 1, 1], 1)); // [3,0,1,0,0]
    println!("{:?}", delayed_count(vec![1, 2, 1, 1, 1], 0)); // [3,0,2,1,0]
}
