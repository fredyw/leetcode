// https://leetcode.com/problems/limit-occurrences-in-sorted-array/description/
pub fn limit_occurrences(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut answer = vec![];
    let mut count = 0;
    for i in 0..nums.len() {
        if i == 0 || nums[i - 1] == nums[i] {
            count += 1;
        } else if nums[i - 1] != nums[i] {
            count = 1;
        }
        if count <= k {
            answer.push(nums[i]);
        }
    }
    answer
}

fn main() {
    println!("{:?}", limit_occurrences(vec![1, 1, 1, 2, 2, 3], 2)); // [1,1,2,2,3]
    println!("{:?}", limit_occurrences(vec![1, 2, 3], 1)); // [1,2,3]
}
