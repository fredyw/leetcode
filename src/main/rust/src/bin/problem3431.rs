// https://leetcode.com/problems/minimum-unlocked-indices-to-sort-nums/description/
pub fn min_unlocked_indices(mut nums: Vec<i32>, mut locked: Vec<i32>) -> i32 {
    fn is_sorted(nums: &Vec<i32>) -> bool {
        for i in 0..nums.len() - 1 {
            if nums[i] > nums[i + 1] {
                return false;
            }
        }
        true
    }

    let mut answer = 0;
    loop {
        let mut num_swaps = 0;
        for i in 0..nums.len() - 1 {
            if nums[i] > nums[i + 1] {
                if nums[i] - nums[i + 1] == 1 {
                    if locked[i] == 1 {
                        answer += 1;
                        locked[i] = 0;
                    }
                    nums.swap(i, i + 1);
                    num_swaps += 1;
                } else {
                    return -1;
                }
            }
        }
        let is_sorted = is_sorted(&nums);
        if is_sorted {
            break;
        }
        if num_swaps == 0 {
            return -1;
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
    println!("{}", min_unlocked_indices(vec![2, 2, 1], vec![1, 0, 0])); // 1
}
