// https://leetcode.com/problems/sort-array-using-prefix-reversals/description/
pub fn sort_array(nums: Vec<i32>, pre: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", sort_array(vec![2, 0, 1], vec![2, 3])); // 2
    println!("{}", sort_array(vec![1, 0, 2], vec![1, 3])); // -1
    println!("{}", sort_array(vec![0, 1], vec![2])); // 0
}
