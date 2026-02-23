// https://leetcode.com/problems/delayed-count-of-equal-elements/description/
pub fn delayed_count(nums: Vec<i32>, k: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", delayed_count(vec![1, 2, 1, 1], 1)); // [2,0,0,0]
    println!("{:?}", delayed_count(vec![3, 1, 3, 1], 0)); // [1,1,0,0]
    println!("{:?}", delayed_count(vec![1, 2, 1, 1, 1], 1)); // [3,0,1,0,0]
    println!("{:?}", delayed_count(vec![1, 2, 1, 1, 1], 0)); // [3,0,2,1,0]
}
