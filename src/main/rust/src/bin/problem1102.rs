use std::collections::BinaryHeap;

// https://leetcode.com/problems/path-with-maximum-minimum-value/description/
pub fn maximum_minimum_path(grid: Vec<Vec<i32>>) -> i32 {
    let num_rows = grid.len() as isize;
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 } as isize;
    let mut visited = vec![vec![false; num_cols as usize]; num_rows as usize];
    let mut heap: BinaryHeap<(i32, (isize, isize))> = BinaryHeap::new();
    heap.push((grid[0][0], (0, 0)));
    visited[0][0] = true;
    while let Some((score, (row, col))) = heap.pop() {
        if row == num_rows - 1 && col == num_cols - 1 {
            return score;
        }
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            let new_row = row + r;
            let new_col = col + c;
            if new_row < 0
                || new_col < 0
                || new_row == num_rows
                || new_col == num_cols
                || visited[new_row as usize][new_col as usize]
            {
                continue;
            }
            visited[new_row as usize][new_col as usize] = true;
            heap.push((
                score.min(grid[new_row as usize][new_col as usize]),
                (new_row, new_col),
            ));
        }
    }
    -1
}

fn main() {
    println!(
        "{}",
        maximum_minimum_path(vec![vec![5, 4, 5], vec![1, 2, 6], vec![7, 4, 6]])
    ); // 4
    println!(
        "{}",
        maximum_minimum_path(vec![vec![2, 2, 1, 2, 2, 2], vec![1, 2, 2, 2, 1, 2]])
    ); // 2
    println!(
        "{}",
        maximum_minimum_path(vec![
            vec![3, 4, 6, 3, 4],
            vec![0, 2, 1, 1, 7],
            vec![8, 8, 3, 2, 7],
            vec![3, 2, 4, 9, 8],
            vec![4, 1, 2, 0, 0],
            vec![4, 6, 5, 4, 3]
        ])
    ); // 3
}
