// https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/description/
pub fn smallest_index(nums: Vec<i32>) -> i32 {
    let mut answer = -1;
    for (i, n) in nums.into_iter().enumerate() {
        let sum: i32 = n.to_string().chars().map(|c| c as i32 - '0' as i32).sum();
        if sum == i as i32 {
            if answer == -1 {
                answer = i as i32;
            } else {
                answer = answer.min(i as i32);
            }
        }
    }
    answer
}

fn main() {
    println!("{}", smallest_index(vec![1, 3, 2])); // 2
    println!("{}", smallest_index(vec![1, 10, 11])); // 1
    println!("{}", smallest_index(vec![1, 2, 3])); // -1
}
