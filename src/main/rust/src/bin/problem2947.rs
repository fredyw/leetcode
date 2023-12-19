// https://leetcode.com/problems/count-beautiful-substrings-i/description/
pub fn beautiful_substrings(s: String, k: i32) -> i32 {
    fn is_vowel(b: u8) -> bool {
        b == 'a' as u8 || b == 'e' as u8 || b == 'i' as u8 || b == 'o' as u8 || b == 'u' as u8
    }

    let mut answer = 0;
    let bytes = s.as_bytes();
    for i in 0..bytes.len() {
        let mut vowel_count = 0;
        let mut consonant_count = 0;
        for j in i..bytes.len() {
            if is_vowel(bytes[j]) {
                vowel_count += 1;
            } else {
                consonant_count += 1;
            }
            if vowel_count == consonant_count && (vowel_count * consonant_count) % k == 0 {
                answer += 1;
            }
        }
    }
    answer
}

fn main() {
    println!("{}", beautiful_substrings("baeyh".to_string(), 2)); // 2
    println!("{}", beautiful_substrings("abba".to_string(), 1)); // 3
    println!("{}", beautiful_substrings("bcdf".to_string(), 1)); // 0
    println!("{}", beautiful_substrings("abbaa".to_string(), 1)); // 4
    println!("{}", beautiful_substrings("abbaaa".to_string(), 1)); // 4
    println!("{}", beautiful_substrings("abbaaab".to_string(), 1)); // 6
    println!("{}", beautiful_substrings("aaabb".to_string(), 1)); // 2
}
