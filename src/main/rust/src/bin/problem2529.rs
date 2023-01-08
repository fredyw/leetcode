// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/
pub fn maximum_count(nums: Vec<i32>) -> i32 {
    let mut neg_count = 0;
    let mut pos_count = 0;
    for num in nums.into_iter() {
        if num < 0 {
            neg_count += 1;
        } else if num > 0 {
            pos_count += 1;
        }
    }
    neg_count.max(pos_count)
}

fn main() {
    println!("{}", maximum_count(vec![-2, -1, -1, 1, 2, 3])); // 3
    println!("{}", maximum_count(vec![-3, -2, -1, 0, 0, 1, 2])); // 3
    println!("{}", maximum_count(vec![5, 20, 66, 1314])); // 4
}
