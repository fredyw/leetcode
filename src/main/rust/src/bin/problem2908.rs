// https://leetcode.com/problems/minimum-sum-of-mountain-triplets-i/description/
pub fn minimum_sum(nums: Vec<i32>) -> i32 {
    let mut answer = i32::MAX;
    for i in 0..nums.len() {
        for j in i + 1..nums.len() {
            for k in j + 1..nums.len() {
                if nums[i] < nums[j] && nums[k] < nums[j] {
                    answer = answer.min(nums[i] + nums[j] + nums[k]);
                }
            }
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", minimum_sum(vec![8, 6, 1, 5, 3])); // 9
    println!("{}", minimum_sum(vec![5, 4, 8, 7, 10, 2])); // 13
    println!("{}", minimum_sum(vec![6, 5, 4, 3, 4, 5])); // -1
}
