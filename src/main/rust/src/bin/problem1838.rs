// https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
pub fn max_frequency(mut nums: Vec<i32>, k: i32) -> i32 {
    nums.sort();
    let mut answer = 1;
    let mut right = nums.len() as isize - 1;
    let mut left = right - 1;
    let mut count = 1;
    let mut n = k;
    while left >= 0 {
        let diff = nums[right as usize] - nums[left as usize];
        if n - diff < 0 {
            if n < k {
                n += nums[right as usize] - nums[right as usize - 1];
            }
            right -= 1;
            count -= 1;
        } else {
            count += 1;
            left -= 1;
            n -= diff;
        }
        answer = answer.max(count);
    }
    answer
}

fn main() {
    println!("{}", max_frequency(vec![1, 2, 4], 5)); // 3
    println!("{}", max_frequency(vec![1, 4, 8, 13], 5)); // 2
    println!("{}", max_frequency(vec![3, 9, 6], 2)); // 1
    println!("{}", max_frequency(vec![1, 4, 6, 10, 12, 17], 10)); // 3
    println!("{}", max_frequency(vec![1, 2, 3, 9, 10], 3)); // 3
}
