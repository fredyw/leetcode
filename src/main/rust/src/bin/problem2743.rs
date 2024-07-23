// https://leetcode.com/problems/count-substrings-without-repeating-character/description/
pub fn number_of_special_substrings(s: String) -> i32 {
    todo!()
}

fn main() {
    println!("{}", number_of_special_substrings("abcd".to_string())); // 10
    println!("{}", number_of_special_substrings("ooo".to_string())); // 3
    println!("{}", number_of_special_substrings("abab".to_string())); // 7
    println!("{}", number_of_special_substrings("abcde".to_string())); // 15
    println!("{}", number_of_special_substrings("abc".to_string())); // 6
    println!("{}", number_of_special_substrings("abcabcabc".to_string())); // 24
}
