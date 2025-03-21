// https://leetcode.com/problems/house-robber-iv/
pub fn min_capability(nums: Vec<i32>, k: i32) -> i32 {
    let mut min = i32::MAX;
    let mut max = i32::MIN;
    for num in nums.iter() {
        min = min.min(*num);
        max = max.max(*num);
    }
    while min < max {
        let mid = (min + min) / 2;
    }
    min
}

fn main() {
    println!("{}", min_capability(vec![2, 3, 5, 9], 2)); // 5
    println!("{}", min_capability(vec![2, 7, 9, 3, 1], 2)); // 2
}
