// https://leetcode.com/problems/find-if-array-can-be-sorted/description/
pub fn can_sort_array(nums: Vec<i32>) -> bool {
    let mut sorted_nums = nums.clone();
    sorted_nums.sort();
    false
}

fn main() {
    println!("{}", can_sort_array(vec![8, 4, 2, 30, 15])); // true
    println!("{}", can_sort_array(vec![1, 2, 3, 4, 5])); // true
    println!("{}", can_sort_array(vec![3, 16, 8, 4, 2])); // false
    println!("{}", can_sort_array(vec![16, 8, 4, 2])); // true
    println!("{}", can_sort_array(vec![16, 3])); // false
}
