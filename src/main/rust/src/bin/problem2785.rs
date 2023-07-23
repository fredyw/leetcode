// https://leetcode.com/problems/sort-vowels-in-a-string/
pub fn sort_vowels(s: String) -> String {
    fn is_vowel(c: char) -> bool {
        c == 'a'
            || c == 'e'
            || c == 'i'
            || c == 'o'
            || c == 'u'
            || c == 'A'
            || c == 'E'
            || c == 'I'
            || c == 'O'
            || c == 'U'
    }

    let mut chars: Vec<char> = s.chars().collect();
    let mut vowels: Vec<char> = chars.iter().copied().filter(|c| is_vowel(*c)).collect();
    vowels.sort_by(|a, b| a.cmp(b));
    let mut j = 0;
    for i in 0..chars.len() {
        if is_vowel(chars[i]) {
            chars[i] = vowels[j];
            j += 1;
        }
    }
    chars.into_iter().collect()
}

fn main() {
    println!("{}", sort_vowels("lEetcOde".to_string())); // "lEOtcede"
    println!("{}", sort_vowels("lYmpH".to_string())); // "lYmpH"
}
