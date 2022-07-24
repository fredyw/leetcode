// https://leetcode.com/problems/first-letter-to-appear-twice/
pub fn repeated_character(s: String) -> char {
    let mut char_counts = vec![0; 26];
    let chars: Vec<char> = s.chars().into_iter().collect();
    for c in chars.iter() {
        char_counts[*c as usize - 'a' as usize] += 1;
        if char_counts[*c as usize - 'a' as usize] == 2 {
            return *c;
        }
    }
    panic!()
}

fn main() {
    println!("{}", repeated_character("abccbaacz".to_string())); // "c"
    println!("{}", repeated_character("abcdd".to_string())); // "d"
}
