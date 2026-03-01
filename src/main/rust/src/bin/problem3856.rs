// https://leetcode.com/problems/trim-trailing-vowels/description/
pub fn trim_trailing_vowels(s: String) -> String {
    let chars: Vec<char> = s.chars().collect();
    let mut i = chars.len() as isize - 1;
    while i >= 0 {
        if chars[i as usize] != 'a'
            && chars[i as usize] != 'e'
            && chars[i as usize] != 'i'
            && chars[i as usize] != 'o'
            && chars[i as usize] != 'u'
        {
            break;
        }
        i -= 1;
    }
    if i < 0 {
        "".to_string()
    } else {
        let sub = &chars[0..=i as usize];
        sub.to_owned().into_iter().collect()
    }
}

fn main() {
    println!("{}", trim_trailing_vowels("idea".to_string())); // "id"
    println!("{}", trim_trailing_vowels("day".to_string())); // "day"
    println!("{}", trim_trailing_vowels("aeiou".to_string())); // ""
}
