// https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/
pub fn results_array(nums: Vec<i32>, k: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", results_array(vec![1, 2, 3, 4, 3, 2, 5], 3)); // [3,4,-1,-1,-1]
    println!("{:?}", results_array(vec![2, 2, 2, 2, 2], 4)); // [-1,-1]
    println!("{:?}", results_array(vec![3, 2, 3, 2, 3, 2], 2)); // [-1,3,-1,3,-1]
}
