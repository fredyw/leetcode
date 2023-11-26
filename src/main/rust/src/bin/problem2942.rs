// https://leetcode.com/problems/find-words-containing-character/description/
pub fn find_words_containing(words: Vec<String>, x: char) -> Vec<i32> {
    words
        .iter()
        .enumerate()
        .map(|(i, w)| if w.contains(x) { i as i32 } else { -1 })
        .filter(|&i| i != -1)
        .collect()
}

fn main() {
    println!(
        "{:?}",
        find_words_containing(vec!["leet".to_string(), "code".to_string()], 'e')
    ); // [0,1]
    println!(
        "{:?}",
        find_words_containing(
            vec![
                "abc".to_string(),
                "bcd".to_string(),
                "aaaa".to_string(),
                "cbc".to_string()
            ],
            'a'
        )
    ); // [0,2]
    println!(
        "{:?}",
        find_words_containing(
            vec![
                "abc".to_string(),
                "bcd".to_string(),
                "aaaa".to_string(),
                "cbc".to_string()
            ],
            'z'
        )
    ); // []
}
