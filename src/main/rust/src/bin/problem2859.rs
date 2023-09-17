// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/
pub fn sum_indices_with_k_set_bits(nums: Vec<i32>, k: i32) -> i32 {
    fn count_bits(n: usize) -> i32 {
        let mut count = 0;
        let mut i = n;
        while i > 0 {
            if i & 1 == 1 {
                count += 1;
            }
            i >>= 1;
        }
        count
    }

    let mut answer = 0;
    for (i, n) in nums.into_iter().enumerate() {
        if count_bits(i) == k {
            answer += n;
        }
    }
    answer
}

fn main() {
    println!("{}", sum_indices_with_k_set_bits(vec![5, 10, 1, 5, 2], 1)); // 13
    println!("{}", sum_indices_with_k_set_bits(vec![4, 3, 2, 1], 2)); // 1
}
