// https://leetcode.com/problems/maximize-sum-of-at-most-k-distinct-elements/description/
pub fn max_k_distinct(mut nums: Vec<i32>, k: i32) -> Vec<i32> {
    nums.sort_by(|a, b| b.cmp(a));
    nums.dedup();
    nums[0..(k as usize).min(nums.len())].to_vec()
}

fn main() {
    println!("{:?}", max_k_distinct(vec![84, 93, 100, 77, 90], 3)); // [100,93,90]
    println!("{:?}", max_k_distinct(vec![84, 93, 100, 77, 93], 3)); // [100,93,84]
    println!("{:?}", max_k_distinct(vec![1, 1, 1, 2, 2, 2], 6)); // [2,1]
}
