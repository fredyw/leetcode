// https://leetcode.com/problems/check-if-string-is-decomposable-into-value-equal-substrings/description/
pub fn is_decomposable(s: String) -> bool {
    let bytes = s.as_bytes();
    let mut i = 0;
    let mut length_two_count = 0;
    let mut length_three_count = 0;
    while i < bytes.len() {
        let first = bytes[i];
        let mut length = 0;
        while i < bytes.len() && first == bytes[i] {
            i += 1;
            length += 1;
        }
        if length % 3 == 0 {
            length_three_count += length_three_count / 3;
        } else if length == 2 {
            length_two_count += 1;
            if length_two_count > 1 {
                return false;
            }
        } else {
            if length < 2 {
                return false;
            }
            if length - 2 % 3 != 0 {
                return false;
            }
            length_two_count += 1;
            if length_two_count > 1 {
                return false;
            }
        }
    }
    println!("{length_two_count}");
    length_two_count == 1 && length_three_count > 0
}

fn main() {
    // println!("{}", is_decomposable("000111000".to_string())); // false
    println!("{}", is_decomposable("00011111222".to_string())); // true
                                                                // println!("{}", is_decomposable("011100022233".to_string())); // false
                                                                // println!("{}", is_decomposable("11100022233".to_string())); // true
                                                                // println!("{}", is_decomposable("33".to_string())); // false
}
