use std::collections::HashMap;

// https://leetcode.com/problems/first-completely-painted-row-or-column/
pub fn first_complete_index(arr: Vec<i32>, mat: Vec<Vec<i32>>) -> i32 {
    let num_rows = mat.len();
    let num_cols = if num_rows > 0 { mat[0].len() } else { 0 };
    let mut row_counts = vec![0; num_rows];
    let mut col_counts = vec![0; num_cols];
    let mut map: HashMap<i32, (usize, usize)> = HashMap::new();
    for i in 0..num_rows {
        for j in 0..num_cols {
            map.insert(mat[i][j], (i, j));
        }
    }
    for (i, num) in arr.iter().enumerate() {
        let (row, col) = map.get(num).unwrap();
        row_counts[*row] += 1;
        col_counts[*col] += 1;
        if row_counts[*row] == num_cols {
            return i as i32;
        }
        if col_counts[*col] == num_rows {
            return i as i32;
        }
    }
    0
}

fn main() {
    println!(
        "{}",
        first_complete_index(vec![1, 3, 4, 2], vec![vec![1, 4], vec![2, 3]])
    ); // 2
    println!(
        "{}",
        first_complete_index(
            vec![2, 8, 7, 4, 1, 3, 5, 6, 9],
            vec![vec![3, 2, 5], vec![1, 4, 6], vec![8, 7, 9]]
        )
    ); // 3
    println!(
        "{}",
        first_complete_index(vec![1, 4, 5, 2, 6, 3], vec![vec![4, 3, 5], vec![1, 2, 6]])
    ); // 1
}
