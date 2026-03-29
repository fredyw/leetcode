// https://leetcode.com/problems/valid-subarrays-with-exactly-one-peak/description/
pub fn valid_subarrays(nums: Vec<i32>, k: i32) -> i64 {
    let mut answer = 0;
    let k = k as i64;
    let mut peaks: Vec<i64> = Vec::new();
    for i in 1..nums.len() - 1 {
        if nums[i] > nums[i - 1] && nums[i] > nums[i + 1] {
            peaks.push(i as i64);
        }
    }
    let mut peak_index: isize = 0;
    for i in 1..nums.len() - 1 {
        if nums[i] > nums[i - 1] && nums[i] > nums[i + 1] {
            let left = if peak_index - 1 >= 0 {
                (i as i64).min(k + 1).min(peaks[peak_index as usize - 1])
            } else {
                (i as i64).min(k + 1)
            } + 1;
            let right = if peak_index + 1 < peaks.len() as isize {
                (nums.len() as i64 - i as i64)
                    .min(k + 1)
                    .min(peaks[peak_index as usize + 1] - 1)
            } else {
                (nums.len() as i64 - i as i64).min(k + 1)
            };
            println!("i: {i}, left = {left}, right = {right}");
            answer += left * right;
            peak_index += 1;
        }
    }
    answer
}

fn main() {
    // println!("{}", valid_subarrays(vec![1, 3, 2], 1)); // 4
    // println!("{}", valid_subarrays(vec![7, 8, 9], 2)); // 0
    // println!("{}", valid_subarrays(vec![4, 3, 5, 1], 2)); // 6
    // println!("{}", valid_subarrays(vec![1, 4, 2, 5, 2], 5)); // 8
    println!("{}", valid_subarrays(vec![1, 3, 2, 4, 3, 5, 1, 4, 2], 2)); // 16
                                                                         // println!("{}", valid_subarrays(vec![1, 3, 2, 4, 3, 5, 1, 4, 2], 3)); // 16
}
