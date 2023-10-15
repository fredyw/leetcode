// https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/description/
pub fn find_indices(nums: Vec<i32>, index_difference: i32, value_difference: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", find_indices(vec![5, 1, 4, 1], 2, 4)); // [0,3]
    println!("{:?}", find_indices(vec![2, 1], 0, 0)); // [0,0]
    println!("{:?}", find_indices(vec![1, 2, 3], 2, 4)); // [-1,-1]
}
