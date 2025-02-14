use std::collections::HashMap;

// https://leetcode.com/problems/match-alphanumerical-pattern-in-matrix-i/description/
pub fn find_pattern(board: Vec<Vec<i32>>, pattern: Vec<String>) -> Vec<i32> {
    let mut patterns: Vec<Vec<char>> = vec![];
    for p in pattern {
        patterns.push(p.chars().collect());
    }
    let pat_num_rows = patterns.len();
    let pat_num_cols = patterns[0].len();
    for board_row in 0..board.len() - pat_num_rows {
        for board_col in 0..board[board_row].len() - pat_num_rows {
            let mut map: HashMap<char, i32> = HashMap::new();
            let mut found = true;
            'outer: for pat_row in 0..pat_num_rows {
                for pat_col in 0..pat_num_cols {
                    let b_row = board_row + pat_row;
                    let b_col = board_col + pat_col;
                    if let Some(num) = map.get(&patterns[pat_row][pat_col]) {
                        if *num != board[b_row][b_col] {
                            found = false;
                            break 'outer;
                        }
                    }
                    map.insert(patterns[pat_row][pat_col], board[b_row][b_col]);
                }
            }
            if found {
                return vec![board_row as i32, board_col as i32];
            }
        }
    }
    vec![-1, -1]
}

fn main() {
    // println!(
    //     "{:?}",
    //     find_pattern(
    //         vec![vec![1, 2, 2], vec![2, 2, 3], vec![2, 3, 3]],
    //         vec!["ab".to_string(), "bb".to_string()]
    //     )
    // ); // [0,0]
    println!(
        "{:?}",
        find_pattern(
            vec![vec![1, 1, 2], vec![3, 3, 4], vec![6, 6, 6]],
            vec!["ab".to_string(), "66".to_string()]
        )
    ); // [1,1]
       // println!(
       //     "{:?}",
       //     find_pattern(vec![vec![1, 2], vec![2, 1]], vec!["xx".to_string()])
       // ); // [-1,-1]
}
