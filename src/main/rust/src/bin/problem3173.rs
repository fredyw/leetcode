// https://leetcode.com/problems/bitwise-or-of-adjacent-elements/description/
pub fn or_array(nums: Vec<i32>) -> Vec<i32> {
    let mut answer: Vec<i32> = vec![];
    for i in 0..nums.len() - 1 {
        answer.push(nums[i] | nums[i + 1]);
    }
    answer
}

fn main() {
    println!("{:?}", or_array(vec![1, 3, 7, 15])); // [3,7,15]
    println!("{:?}", or_array(vec![8, 4, 2])); // [12,6]
    println!("{:?}", or_array(vec![5, 4, 9, 11])); // [5,13,11]
}
