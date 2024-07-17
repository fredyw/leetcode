// https://leetcode.com/problems/largest-subarray-length-k/description/
pub fn largest_subarray(nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut answer = &nums[0..k as usize];
    for i in 1..nums.len() - k as usize + 1 {
        if answer < &nums[i..i + k as usize] {
            answer = &nums[i..i + k as usize];
        }
    }
    answer.iter().copied().collect()
}

fn main() {
    println!("{:?}", largest_subarray(vec![1, 4, 5, 2, 3], 3)); // [5,2,3]
    println!("{:?}", largest_subarray(vec![1, 4, 5, 2, 3], 4)); // [4,5,2,3]
    println!("{:?}", largest_subarray(vec![1, 4, 5, 2, 3], 1)); // [5]
}
