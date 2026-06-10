// https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/description/
pub fn smallest_subarrays(nums: Vec<i32>) -> Vec<i32> {
    let mut answer = vec![0; nums.len()];
    let mut set: Vec<usize> = vec![0; 31];
    for (i, num) in nums.iter().enumerate().rev() {
        let mut n = *num;
        let mut pos = 0;
        while n > 0 {
            if (n & 1) == 1 {
                set[pos as usize] = i;
            }
            n >>= 1;
            pos += 1;
        }
        let max_index = *set.iter().max().unwrap_or(&i);
        answer[i] = (max_index - i) as i32 + 1;
    }
    answer
}

fn main() {
    // println!("{:?}", smallest_subarrays(vec![1, 0, 2, 1, 3])); // [3,3,2,2,1]
    // println!("{:?}", smallest_subarrays(vec![1, 2])); // [2,1]
    println!("{:?}", smallest_subarrays(vec![1, 0])); // [1,1]
}
