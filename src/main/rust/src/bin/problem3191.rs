// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
pub fn min_operations(mut nums: Vec<i32>) -> i32 {
    fn flip(nums: &mut Vec<i32>, i: usize) {
        nums[i] = if nums[i] == 0 { 1 } else { 0 };
        nums[i + 1] = if nums[i + 1] == 0 { 1 } else { 0 };
        nums[i + 2] = if nums[i + 2] == 0 { 1 } else { 0 };
    }

    let mut answer = 0;
    let mut i = 0;
    while i <= nums.len() - 3 {
        if nums[i] == 0 {
            answer += 1;
            flip(&mut nums, i);
        }
        i += 1;
    }
    if nums[i - 1] == 1 && nums[i] == 1 && nums[i + 1] == 1 {
        answer
    } else {
        -1
    }
}

fn main() {
    println!("{}", min_operations(vec![0, 1, 1, 1, 0, 0])); // 3
    println!("{}", min_operations(vec![0, 1, 1, 1, 0, 0])); // 3
    println!("{}", min_operations(vec![0, 0, 0])); // 1
    println!("{}", min_operations(vec![1, 1, 1])); // 0
}
