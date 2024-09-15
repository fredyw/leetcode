// https://leetcode.com/problems/find-indices-of-stable-mountains/description/
pub fn stable_mountains(height: Vec<i32>, threshold: i32) -> Vec<i32> {
    let mut answer = vec![];
    for i in 1..height.len() {
        if height[i - 1] > threshold {
            answer.push(i as i32);
        }
    }
    answer
}

fn main() {
    println!("{:?}", stable_mountains(vec![1, 2, 3, 4, 5], 2)); // [3,4]
    println!("{:?}", stable_mountains(vec![10, 1, 10, 1, 10], 3)); // [1,3]
    println!("{:?}", stable_mountains(vec![10, 1, 10, 1, 10], 10)); // []
}
