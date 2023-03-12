// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
    fn is_vowel(c: char) -> bool {
        c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }

    let mut answer = 0;
    for i in left..=right {
        let chars: Vec<char> = words[i as usize].chars().collect();
        if is_vowel(chars[0]) && is_vowel(chars[chars.len() - 1]) {
            answer += 1;
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        vowel_strings(
            vec!["are".to_string(), "amy".to_string(), "u".to_string()],
            0,
            2
        )
    ); // 2
    println!(
        "{}",
        vowel_strings(
            vec![
                "hey".to_string(),
                "aeo".to_string(),
                "mu".to_string(),
                "ooo".to_string(),
                "artro".to_string()
            ],
            1,
            4
        )
    ); // 3
}
