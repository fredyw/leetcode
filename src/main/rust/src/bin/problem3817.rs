// https://leetcode.com/problems/good-indices-in-a-digit-string/description/
pub fn good_indices(s: String) -> Vec<i32> {
    todo!()
}

fn main() {
    println!("{:?}", good_indices("0234567890112".to_string())); // [0,11,12]]
    println!("{:?}", good_indices("01234".to_string())); // [0,1,2,3,4]
    println!("{:?}", good_indices("12345".to_string())); // []
}
