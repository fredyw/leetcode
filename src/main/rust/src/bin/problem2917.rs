// https://leetcode.com/problems/find-the-k-or-of-an-array/description/
pub fn find_k_or(nums: Vec<i32>, k: i32) -> i32 {
    let mut answer = 0;
    for i in 0..32 {
        let mut count = 0;
        for num in nums.iter() {
            if *num >> i & 1 == 1 {
                count += 1;
            }
        }
        if count >= k {
            answer += 2_i32.pow(i);
        }
    }
    answer
}

fn main() {
    println!("{}", find_k_or(vec![7, 12, 9, 8, 9, 15], 4)); // 9
    println!("{}", find_k_or(vec![2, 12, 1, 11, 4, 5], 6)); // 0
    println!("{}", find_k_or(vec![10, 8, 5, 9, 11, 6, 8], 1)); // 15
}
