// https://leetcode.com/problems/find-xor-beauty-of-array/
pub fn xor_beauty(nums: Vec<i32>) -> i32 {
    nums.into_iter().reduce(|acc, num| acc ^ num).unwrap()
}

fn main() {
    println!("{}", xor_beauty(vec![1, 4])); // 5
    println!("{}", xor_beauty(vec![15, 45, 20, 2, 34, 35, 5, 44, 32, 30])); // 34
}
