// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
    let mut n = nums.into_iter().reduce(|acc, n| acc ^ n).unwrap() ^ k;
    let mut answer = 0;
    while n > 0 {
        if n & 1 == 1 {
            answer += 1;
        }
        n = n >> 1;
    }
    answer
}

fn main() {
    println!("{}", min_operations(vec![2, 1, 3, 4], 1)); // 2
    println!("{}", min_operations(vec![2, 0, 2, 0], 0)); // 0
    println!("{}", min_operations(vec![2, 1, 3, 4], 5)); // 1
    println!("{}", min_operations(vec![2, 1, 3, 4], 7)); // 2
}
