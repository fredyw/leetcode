use std::collections::HashSet;

// https://leetcode.com/problems/extra-characters-in-a-string/
pub fn min_extra_char(s: String, dictionary: Vec<String>) -> i32 {
    fn min_extra_char(
        s: &str,
        dictionary: &HashSet<String>,
        i: usize,
        j: usize,
        memo: &mut Vec<Vec<i32>>,
    ) -> i32 {
        if j == s.len() {
            return if dictionary.contains(&s[i..j]) {
                0
            } else {
                j as i32 - i as i32
            };
        }
        if memo[i][j] != -1 {
            return memo[i][j];
        }
        let min = if dictionary.contains(&s[i..j]) {
            min_extra_char(s, dictionary, i, j + 1, memo).min(min_extra_char(
                s,
                dictionary,
                j,
                j + 1,
                memo,
            ))
        } else {
            min_extra_char(s, dictionary, i, j + 1, memo)
                .min(min_extra_char(s, dictionary, j, j + 1, memo) + (j as i32 - i as i32))
        };
        memo[i][j] = min;
        min
    }

    let dictionary: HashSet<String> = dictionary.into_iter().collect();
    let mut memo = vec![vec![-1; s.len()]; s.len()];
    min_extra_char(&s, &dictionary, 0, 1, &mut memo)
}

fn main() {
    println!(
        "{}",
        min_extra_char(
            "leetscode".to_string(),
            vec![
                "leet".to_string(),
                "code".to_string(),
                "leetcode".to_string()
            ]
        )
    ); // 1
    println!(
        "{}",
        min_extra_char(
            "sayhelloworld".to_string(),
            vec!["hello".to_string(), "world".to_string()]
        )
    ); // 3
    println!(
        "{}",
        min_extra_char(
            "abc".to_string(),
            vec!["xyz".to_string(), "def".to_string()]
        )
    ); // 3
    println!(
        "{}",
        min_extra_char(
            "adbecf".to_string(),
            vec!["xyz".to_string(), "def".to_string()]
        )
    ); // 6
    println!(
        "{}",
        min_extra_char(
            "adbecf".to_string(),
            vec!["abc".to_string(), "def".to_string()]
        )
    ); // 6
    println!(
        "{}",
        min_extra_char(
            "leetscodeleetcode".to_string(),
            vec![
                "leet".to_string(),
                "code".to_string(),
                "leetcode".to_string()
            ]
        )
    ); // 1
    println!(
        "{}",
        min_extra_char(
            "leetcode".to_string(),
            vec![
                "leet".to_string(),
                "code".to_string(),
                "leetcode".to_string()
            ]
        )
    ); // 0
    println!(
        "{}",
        min_extra_char(
            "codewarriorleetcode".to_string(),
            vec!["code".to_string(), "codewarrior".to_string()]
        )
    ); // 4
    println!(
        "{}",
        min_extra_char(
            "leetcodewarriorcodecodecode".to_string(),
            vec![
                "code".to_string(),
                "codewarrior".to_string(),
                "leet".to_string()
            ]
        )
    ); // 0
    println!(
        "{}",
        min_extra_char(
            "abc".to_string(),
            vec!["abc".to_string(), "def".to_string()]
        )
    ); // 0
}
