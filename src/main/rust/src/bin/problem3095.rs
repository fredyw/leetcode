// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/description/
pub fn minimum_subarray_length(nums: Vec<i32>, k: i32) -> i32 {
    let mut answer = i32::MAX;
    for i in 0..nums.len() {
        let mut xor = 0;
        for j in i..nums.len() {
            xor |= nums[j];
            if xor >= k {
                answer = answer.min((j - i) as i32 + 1);
            }
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!("{}", minimum_subarray_length(vec![1, 2, 3], 2)); // 1
    println!("{}", minimum_subarray_length(vec![2, 1, 8], 10)); // 3
    println!("{}", minimum_subarray_length(vec![1, 2], 0)); // 1
    println!("{}", minimum_subarray_length(vec![1, 12, 2, 5], 43)); // -1
}
