// https://leetcode.com/problems/match-alphanumerical-pattern-in-matrix-i/description/
pub fn find_pattern(board: Vec<Vec<i32>>, pattern: Vec<String>) -> Vec<i32> {
    todo!()
}

fn main() {
    println!(
        "{:?}",
        find_pattern(
            vec![vec![1, 2, 2], vec![2, 2, 3], vec![2, 3, 3]],
            vec!["ab".to_string(), "bb".to_string()]
        )
    ); // [0,0]
    println!(
        "{:?}",
        find_pattern(
            vec![vec![1, 1, 2], vec![3, 3, 4], vec![6, 6, 6]],
            vec!["ab".to_string(), "66".to_string()]
        )
    ); // [1,1]
    println!(
        "{:?}",
        find_pattern(vec![vec![1, 2], vec![2, 1]], vec!["xx".to_string()])
    ); // [-1,-1]
}
