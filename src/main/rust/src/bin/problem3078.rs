// https://leetcode.com/problems/match-alphanumerical-pattern-in-matrix-i/description/
pub fn find_pattern(board: Vec<Vec<i32>>, pattern: Vec<String>) -> Vec<i32> {
    let mut patterns: Vec<Vec<char>> = vec![];
    for p in pattern {
        patterns.push(p.chars().collect());
    }
    let num_rows = patterns.len();
    let num_cols = patterns[0].len();
    for row in 0..=board.len() - num_rows {
        for col in 0..=board[row].len() - num_rows {}
    }
    vec![]
}

fn main() {
    println!(
        "{:?}",
        find_pattern(
            vec![vec![1, 2, 2], vec![2, 2, 3], vec![2, 3, 3]],
            vec!["ab".to_string(), "bb".to_string()]
        )
    ); // [0,0]
       // println!(
       //     "{:?}",
       //     find_pattern(
       //         vec![vec![1, 1, 2], vec![3, 3, 4], vec![6, 6, 6]],
       //         vec!["ab".to_string(), "66".to_string()]
       //     )
       // ); // [1,1]
       // println!(
       //     "{:?}",
       //     find_pattern(vec![vec![1, 2], vec![2, 1]], vec!["xx".to_string()])
       // ); // [-1,-1]
}
