// https://leetcode.com/problems/smallest-stable-index-i/description/
pub fn first_stable_index(nums: Vec<i32>, k: i32) -> i32 {
    let mut mins: Vec<i32> = vec![i32::MAX; nums.len()];
    for (i, &n) in nums.iter().enumerate().rev() {
        if i + 1 == nums.len() {
            mins[i] = n;
        } else {
            mins[i] = mins[i + 1].min(n);
        }
    }
    let mut max = 0;
    for (i, &n) in nums.iter().enumerate() {
        max = max.max(n);
        if max - mins[i] <= k {
            return i as i32;
        }
    }
    -1
}

fn main() {
    println!("{}", first_stable_index(vec![5, 0, 1, 4], 3)); // 3
    println!("{}", first_stable_index(vec![3, 2, 1], 1)); // -1
    println!("{}", first_stable_index(vec![0], 0)); // 0
}
