use std::collections::HashSet;

// https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/description/
pub fn check_two_chessboards(coordinate1: String, coordinate2: String) -> bool {
    let mut black: HashSet<String> = HashSet::new();
    let mut white: HashSet<String> = HashSet::new();
    let mut black_first = true;
    for i in 'a'..='h' {
        let mut is_black = black_first;
        for j in 1..=8 {
            let s = format!("{}{}", i, j);
            if is_black {
                black.insert(s);
            } else {
                white.insert(s);
            }
            is_black = !is_black;
        }
        black_first = !black_first;
    }
    (black.contains(&coordinate1) && black.contains(&coordinate2))
        || (white.contains(&coordinate1) && white.contains(&coordinate2))
}

fn main() {
    println!(
        "{}",
        check_two_chessboards("a1".to_string(), "c3".to_string())
    ); // true
    println!(
        "{}",
        check_two_chessboards("a1".to_string(), "h3".to_string())
    ); // false
    println!(
        "{}",
        check_two_chessboards("h7".to_string(), "c8".to_string())
    ); // true
}
