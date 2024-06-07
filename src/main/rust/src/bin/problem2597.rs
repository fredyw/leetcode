// https://leetcode.com/problems/the-number-of-beautiful-subsets/description/
pub fn beautiful_subsets(mut nums: Vec<i32>, k: i32) -> i32 {
    fn beautiful_subsets(nums: &Vec<i32>, k: i32, i: usize, memo: &mut Vec<i32>) -> i32 {
        if memo[i] != -1 {
            return memo[i];
        }
        let mut count = 0;
        for j in i + 1..nums.len() {
            if nums[j] - nums[i] == k {
                continue;
            }
            count += beautiful_subsets(nums, k, j, memo) + 1;
        }
        memo[i] = count;
        count
    }

    nums.sort();
    let mut answer = 0;
    let mut memo: Vec<i32> = vec![-1; nums.len()];
    for i in 0..nums.len() {
        answer += beautiful_subsets(&nums, k, i, &mut memo) + 1;
    }
    answer
}

fn main() {
    // println!("{}", beautiful_subsets(vec![2, 4, 6], 2)); // 4
    // println!("{}", beautiful_subsets(vec![1], 1)); // 1
    // println!("{}", beautiful_subsets(vec![2, 4, 6, 9], 2)); // 9
    // println!("{}", beautiful_subsets(vec![2, 4, 6, 8], 2)); // 7
    // println!("{}", beautiful_subsets(vec![10, 4, 5, 7, 2, 1], 3)); // 23
    println!("{}", beautiful_subsets(vec![1, 2, 3, 5], 3)); // 11
}
