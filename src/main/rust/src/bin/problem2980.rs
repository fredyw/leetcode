// https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/description/
pub fn has_trailing_zeros(nums: Vec<i32>) -> bool {
    let mut count = 0;
    for &num in nums.iter() {
        if num & 1 == 0 {
            count += 1;
        }
    }
    count > 1
}

fn main() {
    println!("{:?}", has_trailing_zeros(vec![1, 2, 3, 4, 5])); // true
    println!("{:?}", has_trailing_zeros(vec![2, 4, 8, 16])); // true
    println!("{:?}", has_trailing_zeros(vec![1, 3, 5, 7, 9])); // false
}
