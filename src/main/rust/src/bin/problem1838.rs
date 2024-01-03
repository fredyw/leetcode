// https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
pub fn max_frequency(mut nums: Vec<i32>, k: i32) -> i32 {
    nums.sort();
    let mut answer = 1;
    let mut right = nums.len() as isize - 1;
    let mut left = right as isize - 1;
    let mut n = k;
    let mut r = 0isize;
    while left >= 0 {
        let diff = nums[right as usize - r as usize] - nums[left as usize];
        println!(
            "left = {}, right = {}, n = {}, diff = {}, final n = {}",
            left,
            right - r,
            n,
            diff,
            n - diff
        );
        if n - diff < 0 {
            r += 1;
            // if n < k {
            n += nums[right as usize] - nums[right as usize - r as usize];
            // }
        } else {
            right -= r;
            r = 0;
            left -= 1;
            n -= diff;
        }
        answer = answer.max(right as i32 - left as i32);
    }
    answer
}

fn main() {
    // println!("{}", max_frequency(vec![1, 2, 4], 5)); // 3
    // println!("{}", max_frequency(vec![1, 4, 8, 13], 5)); // 2
    // println!("{}", max_frequency(vec![3, 9, 6], 2)); // 1
    // println!("{}", max_frequency(vec![1, 4, 6, 10, 12, 17], 10)); // 3
    // println!("{}", max_frequency(vec![1, 2, 3, 9, 10], 3)); // 3
    // println!(
    //     "{}",
    //     max_frequency(vec![1, 39, 399, 320, 239, 9887, 8743, 7123], 1000)
    // ); // 5
    println!("{}", max_frequency(vec![1, 2, 3, 4, 5, 8, 9, 10, 11], 10)); // 5
}
