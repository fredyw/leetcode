// https://leetcode.com/problems/vowels-game-in-a-string/description/
pub fn does_alice_win(s: String) -> bool {
    for c in s.chars() {
        if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
            return true;
        }
    }
    false
}

fn main() {
    println!("{}", does_alice_win("leetcoder".to_string())); // true
    println!("{}", does_alice_win("bbcd".to_string())); // false
    println!("{}", does_alice_win("a".to_string())); // true
    println!("{}", does_alice_win("b".to_string())); // false
    println!("{}", does_alice_win("leetcodera".to_string())); // true
}
