// https://leetcode.com/problems/minimum-unlocked-indices-to-sort-nums/description/
pub fn min_unlocked_indices(nums: Vec<i32>, locked: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut num_locks = 0;
    let mut max = 1;
    for i in 0..nums.len() {
        if max < nums[i] {
            max = nums[i];
            num_locks = 0;
        }
        if nums[i] < max {
            if nums[i] + 1 < max {
                return -1;
            }
            answer += num_locks;
            num_locks = 0;
        }
        num_locks += locked[i];
    }
    answer
}

fn main() {
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 2, 3, 2], vec![1, 0, 1, 1, 0, 1])
    ); // 0
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 1, 3, 2, 2], vec![1, 0, 1, 1, 0, 1, 0])
    ); // 2
    println!(
        "{}",
        min_unlocked_indices(vec![1, 2, 1, 2, 3, 2, 1], vec![0, 0, 0, 0, 0, 0, 0])
    ); // -1
    println!("{}", min_unlocked_indices(vec![3, 2, 1], vec![0, 0, 0])); // -1
    println!("{}", min_unlocked_indices(vec![3, 2, 1], vec![1, 1, 1])); // -1
    println!("{}", min_unlocked_indices(vec![2, 2, 1], vec![1, 0, 0])); // 1
}
