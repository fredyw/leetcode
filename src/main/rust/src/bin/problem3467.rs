// https://leetcode.com/problems/transform-array-by-parity/description/
pub fn transform_array(nums: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![];
    for num in nums {
        answer.push(if num % 2 == 0 { 0 } else { 1 });
    }
    answer.sort();
    answer
}

fn main() {
    println!("{:?}", transform_array(vec![4, 3, 2, 1])); // [0,0,1,1]
    println!("{:?}", transform_array(vec![1, 5, 1, 4, 2])); // [0,0,1,1,1]
    println!("{:?}", transform_array(vec![8])); // [0]
}
