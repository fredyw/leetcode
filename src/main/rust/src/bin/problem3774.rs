// https://leetcode.com/problems/absolute-difference-between-maximum-and-minimum-k-elements/
pub fn abs_difference(mut nums: Vec<i32>, k: i32) -> i32 {
    nums.sort();
    let mut largest = 0;
    let mut smallest = 0;
    for i in 0..k {
        smallest += nums[i as usize];
    }
    for i in nums.len() - k as usize..nums.len() {
        largest += nums[i as usize];
    }
    (smallest - largest).abs()
}

fn main() {
    println!("{}", abs_difference(vec![5, 2, 2, 4], 2)); // 5
    println!("{}", abs_difference(vec![100], 1)); // 0
}
