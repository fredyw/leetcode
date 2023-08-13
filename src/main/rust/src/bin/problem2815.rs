use std::collections::HashMap;

// https://leetcode.com/problems/max-pair-sum-in-an-array/
pub fn max_sum(nums: Vec<i32>) -> i32 {
    let mut map: HashMap<i32, Vec<i32>> = HashMap::new();
    for num in nums.into_iter() {
        let max = format!("{}", num)
            .chars()
            .map(|c| c as i32 - '0' as i32)
            .max()
            .unwrap();
        map.entry(max).or_insert(vec![]).push(num);
    }
    let mut answer = -1;
    for (_, nums) in map.into_iter() {
        if nums.len() > 1 {
            let mut nums = nums;
            nums.sort_by(|a, b| b.cmp(a));
            answer = answer.max(nums[0] + nums[1]);
        }
    }
    answer
}

fn main() {
    println!("{}", max_sum(vec![51, 71, 17, 24, 42])); // 88
    println!("{}", max_sum(vec![1, 2, 3, 4])); // -1
    println!("{}", max_sum(vec![51, 71, 17, 24, 42, 27])); // 98
}
