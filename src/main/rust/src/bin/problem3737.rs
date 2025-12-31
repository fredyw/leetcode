// https://leetcode.com/problems/count-subarrays-with-majority-element-i/description/
pub fn count_majority_subarrays(nums: Vec<i32>, target: i32) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() {
        let mut count = 0;
        for j in i..nums.len() {
            if nums[j] == target {
                count += 1;
            }
            let length = j - i + 1;
            if count > length / 2 {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_majority_subarrays(vec![1, 2, 2, 3], 2)); // 5
    println!("{}", count_majority_subarrays(vec![1, 1, 1, 1], 1)); // 10
    println!("{}", count_majority_subarrays(vec![1, 2, 3], 4)); // 0
}
