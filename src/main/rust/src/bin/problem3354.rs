// https://leetcode.com/problems/make-array-elements-equal-to-zero/
pub fn count_valid_selections(nums: Vec<i32>) -> i32 {
    let mut prefix_sums = vec![0; nums.len()];
    let mut suffix_sums = vec![0; nums.len()];
    let mut i = 0;
    let mut j = nums.len() as isize - 1;
    while i < nums.len() {
        if i == 0 {
            prefix_sums[i] = nums[i];
            suffix_sums[j as usize] = nums[j as usize];
        } else {
            prefix_sums[i] = prefix_sums[i - 1] + nums[i];
            suffix_sums[j as usize] = suffix_sums[j as usize + 1] + nums[j as usize];
        }
        i += 1;
        j -= 1;
    }
    let mut answer = 0;
    for i in 0..nums.len() {
        if nums[i] == 0 {
            let left = if i as isize - 1 < 0 {
                0
            } else {
                prefix_sums[i - 1]
            };
            let right = if i + 1 == nums.len() {
                0
            } else {
                suffix_sums[i + 1]
            };
            if left == right {
                answer += 2;
            } else if left == right + 1 {
                answer += 1;
            } else if left + 1 == right {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", count_valid_selections(vec![1, 0, 2, 0, 3])); // 2
    println!("{}", count_valid_selections(vec![2, 3, 4, 0, 4, 1, 0])); // 0
    println!("{}", count_valid_selections(vec![2, 3, 0, 0, 4, 1, 0])); // 4
    println!("{}", count_valid_selections(vec![2, 3, 0, 0, 4, 1, 1])); // 2
    println!("{}", count_valid_selections(vec![0, 0, 0])); // 6
    println!("{}", count_valid_selections(vec![0])); // 2
    println!("{}", count_valid_selections(vec![0, 0])); // 4
}
