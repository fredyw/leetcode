// https://leetcode.com/problems/remove-vowels-from-a-string/description/
pub fn remove_vowels(s: String) -> String {
    s.chars()
        .into_iter()
        .filter(|c| *c != 'a' && *c != 'e' && *c != 'i' && *c != 'o' && *c != 'u')
        .collect()
}

fn main() {
    println!(
        "{}",
        remove_vowels("leetcodeisacommunityforcoders".to_string())
    ); // "ltcdscmmntyfrcdrs"
    println!("{}", remove_vowels("aeiou".to_string())); // "aeiou"
}
