use std::collections::HashSet;

// https://leetcode.com/problems/find-missing-elements/description/
pub fn find_missing_elements(nums: Vec<i32>) -> Vec<i32> {
    let mut min = i32::MAX;
    let mut max = i32::MIN;
    for num in &nums {
        min = min.min(*num);
        max = max.max(*num);
    }
    let mut answer = vec![];
    let nums: HashSet<i32> = nums.into_iter().collect();
    for num in min..=max {
        if !nums.contains(&num) {
            answer.push(num);
        }
    }
    answer
}

fn main() {
    println!("{:?}", find_missing_elements(vec![1, 4, 2, 5])); // [3]
    println!("{:?}", find_missing_elements(vec![7, 8, 6, 9])); // []
    println!("{:?}", find_missing_elements(vec![5, 1])); // [2,3,4]
}
