use std::collections::HashMap;

// https://leetcode.com/problems/the-number-of-beautiful-subsets/description/
pub fn beautiful_subsets(mut nums: Vec<i32>, k: i32) -> i32 {
    fn remove(map: &mut HashMap<i32, i32>, key: i32) {
        let count = map.entry(key).or_insert(0);
        *count -= 1;
        if *count == 0 {
            map.remove(&key);
        }
    }

    fn beautiful_subsets(nums: &Vec<i32>, k: i32, i: usize, map: &mut HashMap<i32, i32>) -> i32 {
        let mut count = 0;
        *map.entry(nums[i]).or_insert(0) += 1;
        for j in i + 1..nums.len() {
            if map.contains_key(&(nums[j] - k)) {
                continue;
            }
            *map.entry(nums[j]).or_insert(0) += 1;
            count += beautiful_subsets(nums, k, j, map) + 1;
            remove(map, nums[j]);
        }
        remove(map, nums[i]);
        count
    }

    nums.sort();
    let mut answer = 0;
    for i in 0..nums.len() {
        answer += beautiful_subsets(&nums, k, i, &mut HashMap::new()) + 1;
    }
    answer
}

fn main() {
    println!("{}", beautiful_subsets(vec![2, 4, 6], 2)); // 4
    println!("{}", beautiful_subsets(vec![1], 1)); // 1
    println!("{}", beautiful_subsets(vec![2, 4, 6, 9], 2)); // 9
    println!("{}", beautiful_subsets(vec![2, 4, 6, 8], 2)); // 7
    println!("{}", beautiful_subsets(vec![10, 4, 5, 7, 2, 1], 3)); // 23
    println!("{}", beautiful_subsets(vec![1, 1, 1, 4, 4, 4], 2)); // 63
    println!("{}", beautiful_subsets(vec![1, 2, 3, 5], 3)); // 11
    println!("{}", beautiful_subsets(vec![1, 1, 2, 3], 1)); // 8
}
