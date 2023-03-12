// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
    todo!()
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
