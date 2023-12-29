// https://leetcode.com/problems/remove-adjacent-almost-equal-characters/description/
pub fn remove_almost_equal_characters(word: String) -> i32 {
    fn diff(a: u8, b: u8) -> u8 {
        if a > b {
            a - b
        } else {
            b - a
        }
    }

    let mut answer = 0;
    let mut i = 1;
    let bytes = word.as_bytes();
    while i < bytes.len() {
        if diff(bytes[i], bytes[i - 1]) <= 1 {
            i += 2;
            answer += 1;
        } else {
            i += 1;
        }
    }
    answer
}

fn main() {
    println!("{}", remove_almost_equal_characters("aaaaa".to_string())); // 2
    println!("{}", remove_almost_equal_characters("abddez".to_string())); // 2
    println!("{}", remove_almost_equal_characters("zyxyxyz".to_string())); // 3
    println!("{}", remove_almost_equal_characters("abc".to_string())); // 1
    println!("{}", remove_almost_equal_characters("azb".to_string())); // 0
    println!("{}", remove_almost_equal_characters("aab".to_string())); // 1
}
