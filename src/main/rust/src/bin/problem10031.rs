// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/description/
pub fn incremovable_subarray_count(nums: Vec<i32>) -> i32 {
    fn check(nums: &Vec<i32>, i: usize, j: usize) -> bool {
        let mut prev = 0;
        for x in 0..nums.len() {
            if x >= i && x <= j {
                continue;
            }
            if prev > 0 && prev >= nums[x] {
                return false;
            }
            prev = nums[x];
        }
        true
    }

    let mut answer = 0;
    for i in 0..nums.len() {
        for j in i..nums.len() {
            if check(&nums, i, j) {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", incremovable_subarray_count(vec![1, 2, 3, 4])); // 10
    println!("{}", incremovable_subarray_count(vec![6, 5, 7, 8])); // 7
    println!("{}", incremovable_subarray_count(vec![8, 7, 6, 6])); // 3
    println!(
        "{}",
        incremovable_subarray_count(vec![1, 2, 3, 1, 4, 5, 2, 6, 7, 8, 1, 2, 9])
    ); // 11
    println!(
        "{}",
        incremovable_subarray_count(vec![1, 2, 3, 1, 4, 5, 2, 6, 7, 8, 1, 2, 9, 10])
    ); // 15
    println!("{}", incremovable_subarray_count(vec![1, 2, 3, 4, 5])); // 15
}
