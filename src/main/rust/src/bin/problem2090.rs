// https://leetcode.com/problems/k-radius-subarray-averages/
pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", get_averages(vec![7, 4, 3, 9, 1, 8, 5, 2, 6], 3)); // [-1,-1,-1,5,4,4,-1,-1,-1]
    println!("{:?}", get_averages(vec![100000], 0)); // [100000]
    println!("{:?}", get_averages(vec![8], 100000)); // [-1]
}
