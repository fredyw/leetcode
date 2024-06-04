// https://leetcode.com/problems/count-alternating-subarrays/description/
pub fn count_alternating_subarrays(nums: Vec<i32>) -> i64 {
    fn sum(n: i64) -> i64 {
        (n * (1 + n)) / 2
    }

    let mut answer: i64 = 0;
    let mut i = 0;
    let mut length: i64 = 1;
    while i < nums.len() - 1 {
        if nums[i] != nums[i + 1] {
            length += 1;
        } else {
            answer += sum(length);
            length = 1;
        }
        i += 1;
    }
    answer += sum(length);
    answer
}

fn main() {
    println!("{}", count_alternating_subarrays(vec![0, 1, 1, 1])); // 5
    println!("{}", count_alternating_subarrays(vec![1, 0, 1, 0])); // 10
}
