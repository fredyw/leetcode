// https://leetcode.com/problems/minimum-unlocked-indices-to-sort-nums/description/
pub fn min_unlocked_indices(mut nums: Vec<i32>, mut locked: Vec<i32>) -> i32 {
    let mut answer = 0;
    for i in 0..nums.len() - 1 {
        if nums[i] > nums[i + 1] {
            if nums[i] - nums[i + 1] == 1 {
                if locked[i] == 1 {
                    answer += 1;
                    locked[i] = 0;
                }
                nums.swap(i, i + 1);
            } else {
                return -1;
            }
        }
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
}
