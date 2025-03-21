// https://leetcode.com/problems/house-robber-iv/
pub fn min_capability(nums: Vec<i32>, k: i32) -> i32 {
    let mut min = i32::MAX;
    let mut max = i32::MIN;
    for num in nums.iter() {
        min = min.min(*num);
        max = max.max(*num);
    }
    while min < max {
        let mid = (min + max) / 2;
        let mut i = 0;
        let mut thefts = 0;
        while i < nums.len() {
            if nums[i] <= mid {
                thefts += 1;
                i += 1;
            }
            i += 1;
        }
        if thefts >= k {
            max = mid;
        } else {
            min = mid + 1;
        }
    }
    min
}

fn main() {
    println!("{}", min_capability(vec![2, 3, 5, 9], 2)); // 5
    println!("{}", min_capability(vec![2, 7, 9, 3, 1], 2)); // 2
}
