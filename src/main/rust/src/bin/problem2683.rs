// https://leetcode.com/problems/neighboring-bitwise-xor/
pub fn does_valid_array_exist(derived: Vec<i32>) -> bool {
    derived.into_iter().reduce(|acc, i| acc ^ i).unwrap() == 0
}

fn main() {
    println!("{}", does_valid_array_exist(vec![1, 1, 0])); // true
    println!("{}", does_valid_array_exist(vec![1, 1])); // true
    println!("{}", does_valid_array_exist(vec![1, 0])); // false
    println!("{}", does_valid_array_exist(vec![1, 1, 1, 0])); // false
}
