// https://leetcode.com/problems/find-indices-of-stable-mountains/description/
pub fn stable_mountains(height: Vec<i32>, threshold: i32) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", stable_mountains(vec![1, 2, 3, 4, 5], 2)); // [3,4]
    println!("{:?}", stable_mountains(vec![10, 1, 10, 1, 10], 3)); // [1,3]
    println!("{:?}", stable_mountains(vec![10, 1, 10, 1, 10], 10)); // []
}
