// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/description/
pub fn get_words_in_longest_subsequence(
    n: i32,
    words: Vec<String>,
    groups: Vec<i32>,
) -> Vec<String> {
    let mut zero_first = vec![];
    let mut one_first = vec![];
    let mut zero = true;
    let mut one = true;
    for i in 0..n as usize {
        if groups[i] == 0 {
            if zero {
                zero_first.push(words[i].clone());
                zero = !zero;
            }
            if !one {
                one_first.push(words[i].clone());
                one = !one;
            }
        } else {
            if !zero {
                zero_first.push(words[i].clone());
                zero = !zero;
            }
            if one {
                one_first.push(words[i].clone());
                one = !one;
            }
        }
    }
    if zero_first.len() > one_first.len() {
        zero_first
    } else {
        one_first
    }
}

fn main() {
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            3,
            vec!["e".to_string(), "a".to_string(), "b".to_string()],
            vec![0, 0, 1]
        )
    ); // ["e","b"]
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            4,
            vec![
                "a".to_string(),
                "b".to_string(),
                "c".to_string(),
                "d".to_string()
            ],
            vec![1, 0, 1, 1]
        )
    ); // ["a","b","c"]
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            4,
            vec![
                "a".to_string(),
                "b".to_string(),
                "c".to_string(),
                "def".to_string()
            ],
            vec![1, 0, 1, 1]
        )
    ); // ["a","b","c"]
    println!(
        "{:?}",
        get_words_in_longest_subsequence(
            4,
            vec![
                "a".to_string(),
                "b".to_string(),
                "c".to_string(),
                "def".to_string()
            ],
            vec![1, 0, 1, 0]
        )
    ); // ["a","b","c","def"]
}
