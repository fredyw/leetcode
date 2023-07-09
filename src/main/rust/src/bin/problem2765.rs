// https://leetcode.com/problems/longest-alternating-subarray/
pub fn alternating_subarray(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut i = 0;
    let mut found = false;
    let mut is_one = true;
    let mut length = 1;
    while i < nums.len() - 1 {
        if is_one && nums[i + 1] - nums[i] == 1 {
            found = true;
            is_one = false;
            length += 1;
        } else if found && !is_one && nums[i + 1] - nums[i] == -1 {
            is_one = true;
            length += 1;
        } else {
            length = 1;
            if nums[i + 1] - nums[i] == 1 {
                found = true;
                is_one = false;
                length += 1;
            } else {
                found = false;
            }
        }
        answer = answer.max(length);
        i += 1;
    }
    if answer < 2 {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", alternating_subarray(vec![2, 3, 4, 3, 4])); // 4
    println!("{}", alternating_subarray(vec![4, 5, 6])); // 2
    println!("{}", alternating_subarray(vec![1, 2, 2, 1, 2, 3, 6, 2])); // 2
}
