// https://leetcode.com/problems/number-of-unequal-triplets-in-array/
pub fn unequal_triplets(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            for k in j + 1..nums.len() {
                if nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k] {
                    answer += 1;
                }
            }
        }
    }
    answer
}

fn main() {
    println!("{}", unequal_triplets(vec![4, 4, 2, 4, 3])); // 3
    println!("{}", unequal_triplets(vec![4, 4, 2, 4, 3, 4])); // 4
    println!("{}", unequal_triplets(vec![4, 4, 2, 4, 3, 4, 5])); // 13
    println!("{}", unequal_triplets(vec![4, 4, 2, 4, 3, 4, 5, 5])); // 22
    println!("{}", unequal_triplets(vec![1, 1, 1, 1, 1])); // 0
    println!("{}", unequal_triplets(vec![1, 2, 3, 4])); // 4
    println!("{}", unequal_triplets(vec![1, 2, 3, 4, 5])); // 10
}
