// https://leetcode.com/problems/neither-minimum-nor-maximum/
pub fn find_non_min_or_max(nums: Vec<i32>) -> i32 {
    let mut min = i32::MAX;
    let mut max = i32::MIN;
    for num in nums.iter() {
        min = min.min(*num);
        max = max.max(*num);
    }
    for num in nums.iter() {
        if *num != min && *num != max {
            return *num;
        }
    }
    -1
}

fn main() {
    println!("{}", find_non_min_or_max(vec![3, 2, 1, 4])); // 2
    println!("{}", find_non_min_or_max(vec![1, 2])); // -1
    println!("{}", find_non_min_or_max(vec![2, 1, 3])); // 2
}
