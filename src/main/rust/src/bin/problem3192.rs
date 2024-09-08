// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/
pub fn min_operations(nums: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut num_flips = 0;
    for n in nums.iter() {
        let mut n = *n;
        if num_flips % 2 != 0 {
            n = if n == 0 { 1 } else { 0 };
        }
        if n == 0 {
            num_flips += 1;
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!("{:?}", min_operations(vec![0, 1, 1, 0, 1])); // 4
    println!("{:?}", min_operations(vec![1, 0, 0, 0])); // 1
}
