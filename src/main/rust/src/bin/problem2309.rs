// https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
pub fn greatest_letter(s: String) -> String {
    let chars: Vec<char> = s.chars().collect();
    let mut lowercase_counts = vec![false; 26];
    let mut uppercase_counts = vec![false; 26];
    for c in chars {
        if c >= 'a' && c <= 'z' {
            lowercase_counts[c as usize - 'a' as usize] = true;
        } else {
            uppercase_counts[c as usize - 'A' as usize] = true;
        }
    }
    let mut answer = String::from("");
    for lowercase_char in ('a'..='z').rev() {
        let uppercase_char = lowercase_char.to_uppercase().next().unwrap();
        if lowercase_counts[lowercase_char as usize - 'a' as usize]
            && uppercase_counts[uppercase_char as usize - 'A' as usize]
        {
            answer = String::from(uppercase_char);
            break;
        }
    }
    answer
}

fn main() {
    println!("{}", greatest_letter(String::from("lEeTcOdE"))); // "E"
    println!("{}", greatest_letter(String::from("arRAzFif"))); // "R"
    println!("{}", greatest_letter(String::from("AbCdEfGhIjK"))); // ""
}
