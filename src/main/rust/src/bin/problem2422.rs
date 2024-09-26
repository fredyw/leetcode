// https://leetcode.com/problems/merge-operations-to-turn-array-into-a-palindrome/description/
pub fn minimum_operations(mut nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut i = 0;
    let mut j = nums.len() - 1;
    while i < j {
        if nums[i] == nums[j] {
            i += 1;
            j -= 1;
        } else if nums[i] == nums[j] + nums[j - 1] {
            nums[j - 1] += nums[j];
            i += 1;
            j -= 2;
            answer += 1;
        } else if nums[i] + nums[i + 1] == nums[j] {
            nums[i + 1] += nums[i];
            i += 2;
            j -= 1;
            answer += 1;
        } else {
            nums[i + 1] += nums[i];
            i += 1;
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", minimum_operations(vec![4, 3, 2, 1, 2, 3, 1])); // 2
    println!("{}", minimum_operations(vec![1, 2, 3, 4])); // 3
    println!("{}", minimum_operations(vec![1, 2, 3, 4, 3])); // 2
    println!("{}", minimum_operations(vec![1])); // 0
    println!("{}", minimum_operations(vec![1, 1])); // 0
    println!("{}", minimum_operations(vec![1, 2])); // 1
}
