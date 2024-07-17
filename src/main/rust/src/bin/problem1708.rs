// https://leetcode.com/problems/largest-subarray-length-k/description/
pub fn largest_subarray(nums: Vec<i32>, k: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", largest_subarray(vec![1, 4, 5, 2, 3], 3)); // [5,2,3]
    println!("{:?}", largest_subarray(vec![1, 4, 5, 2, 3], 4)); // [4,5,2,3]
    println!("{:?}", largest_subarray(vec![1, 4, 5, 2, 3], 1)); // [5]
}
