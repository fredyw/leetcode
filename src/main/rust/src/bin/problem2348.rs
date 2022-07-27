// https://leetcode.com/problems/number-of-zero-filled-subarrays/
pub fn zero_filled_subarray(nums: Vec<i32>) -> i64 {
    fn sum(n: i32) -> i64 {
        // Arithmetic series formula: (n / 2) * (a1 + a2)
        ((n as f64 / 2.0) * (1 + n) as f64) as i64
    }

    let mut answer: i64 = 0;
    let mut i = 0;
    while i < nums.len() {
        if nums[i] == 0 {
            let mut count = 0;
            while i < nums.len() && nums[i] == 0 {
                count += 1;
                i += 1;
            }
            answer += sum(count)
        }
        i += 1;
    }
    answer
}

fn main() {
    println!("{}", zero_filled_subarray(vec![1, 3, 0, 0, 2, 0, 0, 4])); // 6
    println!("{}", zero_filled_subarray(vec![0, 0, 0, 2, 0, 0])); // 9
    println!("{}", zero_filled_subarray(vec![2, 10, 2019])); // 0
    println!("{}", zero_filled_subarray(vec![0, 0, 0, 0, 0])); // 15
}
