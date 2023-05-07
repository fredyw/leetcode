use std::collections::HashSet;

// https://leetcode.com/problems/find-the-distinct-difference-array/
pub fn distinct_difference_array(nums: Vec<i32>) -> Vec<i32> {
    let mut prefix_set: HashSet<i32> = HashSet::new();
    let mut prefix_sum: Vec<i32> = vec![0; nums.len()];
    for i in 0..nums.len() {
        prefix_set.insert(nums[i]);
        prefix_sum[i] = prefix_set.len() as i32;
    }
    let mut suffix_set: HashSet<i32> = HashSet::new();
    let mut suffix_sum: Vec<i32> = vec![0; nums.len()];
    for i in (0..nums.len()).rev() {
        suffix_set.insert(nums[i]);
        suffix_sum[i] = suffix_set.len() as i32;
    }
    let mut answer: Vec<i32> = vec![0; nums.len()];
    for i in 0..nums.len() {
        answer[i] = prefix_sum[i]
            - if i + 1 == nums.len() {
                0
            } else {
                suffix_sum[i + 1]
            };
    }
    answer
}

fn main() {
    println!("{:?}", distinct_difference_array(vec![1, 2, 3, 4, 5])); // [-3,-1,1,3,5]
    println!("{:?}", distinct_difference_array(vec![3, 2, 3, 4, 2])); // [-2,-1,0,2,3]
}
