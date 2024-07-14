// https://leetcode.com/problems/find-permutation/description/
pub fn find_permutation(s: String) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", find_permutation("I".to_string())); // [1,2]
    println!("{:?}", find_permutation("DI".to_string())); // [2,1,3]
    println!("{:?}", find_permutation("DIDIDIIIIDIIDID".to_string())); // [2,1,4,3,6,5,7,8,9,11,10,12,14,13,16,15]
    println!("{:?}", find_permutation("IDDI".to_string())); // [1,4,3,2,5]
    println!("{:?}", find_permutation("IIII".to_string())); // [1,2,3,4,5]
    println!("{:?}", find_permutation("DDDD".to_string())); // [1,2,3,5,4]
    println!("{:?}", find_permutation("IIIID".to_string())); // [1,2,3,4,6,5]
    println!("{:?}", find_permutation("DDDDI".to_string())); // [5,4,3,2,1,6]
    println!("{:?}", find_permutation("DIDIDI".to_string())); // [2,1,4,3,6,5,7]
    println!("{:?}", find_permutation("IDIDID".to_string())); // [1,3,2,5,4,7,6]
}
