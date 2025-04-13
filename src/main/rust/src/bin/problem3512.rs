// https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/
pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
    nums.iter().sum::<i32>() % k
}

fn main() {
    println!("{}", min_operations(vec![3, 9, 7], 5)); // 4
    println!("{}", min_operations(vec![4, 1, 3], 4)); // 0
    println!("{}", min_operations(vec![3, 2], 6)); // 5
}
