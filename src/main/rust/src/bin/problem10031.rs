// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/
pub fn missing_integer(nums: Vec<i32>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", missing_integer(vec![1, 2, 3, 2, 5])); // 6
    println!("{}", missing_integer(vec![3, 4, 5, 1, 12, 14, 13])); // 15
    println!("{}", missing_integer(vec![1, 2, 3, 9, 10, 11])); // 6
    println!("{}", missing_integer(vec![1, 2, 3, 6, 9, 10, 11])); // 7
    println!("{}", missing_integer(vec![1, 2, 3, 6, 9, 10, 11])); // 7
}
