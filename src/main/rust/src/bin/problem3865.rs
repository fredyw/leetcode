// https://leetcode.com/problems/reverse-k-subarrays/description/
pub fn reverse_subarrays(mut nums: Vec<i32>, k: i32) -> Vec<i32> {
    let mut i = 0;
    let n = nums.len() / k as usize;
    while i < nums.len() {
        nums[i..i + n].reverse();
        i += n;
    }
    nums
}

fn main() {
    println!("{:?}", reverse_subarrays(vec![1, 2, 4, 3, 5, 6], 3)); // [2,1,3,4,6,5]
    println!("{:?}", reverse_subarrays(vec![5, 4, 4, 2], 1)); // [2,4,4,5]
}
