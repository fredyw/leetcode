// https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
pub fn max_frequency(mut nums: Vec<i32>, k: i32) -> i32 {
    nums.sort();
    let mut answer = 0;
    for i in (0..nums.len()).rev() {
        let mut count = 1;
        let mut j = i as isize - 1;
        let mut n = k;
        while j >= 0 {
            n -= nums[i] - nums[j as usize];
            if n < 0 {
                break;
            }
            count += 1;
            j -= 1;
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
