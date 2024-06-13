// https://leetcode.com/problems/valid-word-abbreviation/description/
pub fn valid_word_abbreviation(word: String, abbr: String) -> bool {
    let mut abbreviation: Vec<String> = vec![];
    let mut num = String::new();
    for char in abbr.chars() {
        if char.is_numeric() {
            if num.is_empty() && char == '0' {
                return false;
            }
            num.push(char);
        } else {
            if !num.is_empty() {
                abbreviation.push(num.clone());
            }
            num.clear();
            abbreviation.push(char.to_string());
        }
    }
    if !num.is_empty() {
        abbreviation.push(num.clone());
    }
    let chars: Vec<String> = word.chars().into_iter().map(|c| c.to_string()).collect();
    let mut i = 0;
    let mut j = 0;
    while i < chars.len() {
        if j == abbreviation.len() {
            return false;
        }
        let num = abbreviation[j].parse::<i32>();
        match num {
            Ok(num) => {
                i += num as usize;
                if i > chars.len() {
                    return false;
                }
            }
            Err(_) => {
                if chars[i] != abbreviation[j] {
                    return false;
                }
                i += 1;
            }
        }
        j += 1;
    }
    j == abbreviation.len()
}

fn main() {
    println!(
        "{}",
        valid_word_abbreviation("internationalization".to_string(), "i12iz4n".to_string())
    ); // true
    println!(
        "{}",
        valid_word_abbreviation("apple".to_string(), "a2e".to_string())
    ); // false
    println!(
        "{}",
        valid_word_abbreviation("substitution".to_string(), "12".to_string())
    ); // true
    println!(
        "{}",
        valid_word_abbreviation("substitution".to_string(), "su3i1u2on".to_string())
    ); // true
    println!(
        "{}",
        valid_word_abbreviation("a".to_string(), "01".to_string())
    ); // false
    println!(
        "{}",
        valid_word_abbreviation("substitution".to_string(), "s55n".to_string())
    ); // false
    println!(
        "{}",
        valid_word_abbreviation("substitution".to_string(), "s010n".to_string())
    ); // false
    println!(
        "{}",
        valid_word_abbreviation("substitution".to_string(), "s0ubstitution".to_string())
    ); // false
    println!(
        "{}",
        valid_word_abbreviation("hi".to_string(), "hi1".to_string())
    ); // false
    println!(
        "{}",
        valid_word_abbreviation("hi".to_string(), "1".to_string())
    ); // false
}
