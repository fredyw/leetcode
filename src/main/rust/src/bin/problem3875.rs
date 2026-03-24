// https://leetcode.com/problems/construct-uniform-parity-array-i/description/
pub fn uniform_array(nums1: Vec<i32>) -> bool {
    true
}

fn main() {
    println!("{}", uniform_array(vec![2, 3])); // true
    println!("{}", uniform_array(vec![4, 6])); // true
    println!("{}", uniform_array(vec![5, 10, 15])); // true
    println!("{}", uniform_array(vec![4, 8, 12])); // true
    println!("{}", uniform_array(vec![1, 2, 4])); // true
}
