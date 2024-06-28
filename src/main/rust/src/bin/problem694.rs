use std::collections::HashSet;

//https://leetcode.com/problems/number-of-distinct-islands/description/
pub fn num_distinct_islands(grid: Vec<Vec<i32>>) -> i32 {
    fn dfs(
        grid: &Vec<Vec<i32>>,
        actual_row: i32,
        actual_col: i32,
        virtual_row: i32,
        virtual_col: i32,
        island: &mut String,
        visited: &mut Vec<Vec<bool>>,
    ) {
        let max_rows = grid.len() as i32;
        let max_cols = if max_rows > 0 { grid[0].len() } else { 0 } as i32;
        if actual_row < 0
            || actual_row == max_rows
            || actual_col < 0
            || actual_col == max_cols
            || visited[actual_row as usize][actual_col as usize]
            || grid[actual_row as usize][actual_col as usize] == 0
        {
            return;
        }
        visited[actual_row as usize][actual_col as usize] = true;
        island.push_str(&format!("{virtual_row},{virtual_col}|"));
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            dfs(
                grid,
                actual_row + r,
                actual_col + c,
                virtual_row + r,
                virtual_col + c,
                island,
                visited,
            );
        }
    }

    let mut islands: HashSet<String> = HashSet::new();
    let max_rows = grid.len();
    let max_cols = if max_rows > 0 { grid[0].len() } else { 0 };
    let mut visited = vec![vec![false; max_cols]; max_rows];
    for row in 0..max_rows {
        for col in 0..max_cols {
            if !visited[row][col] && grid[row][col] == 1 {
                let mut island = String::new();
                dfs(
                    &grid,
                    row as i32,
                    col as i32,
                    0,
                    0,
                    &mut island,
                    &mut visited,
                );
                islands.insert(island);
            }
        }
    }
    islands.len() as i32
}

fn main() {
    println!(
        "{}",
        num_distinct_islands(vec![
            vec![1, 1, 0, 0, 0],
            vec![1, 1, 0, 0, 0],
            vec![0, 0, 0, 1, 1],
            vec![0, 0, 0, 1, 1]
        ])
    ); // 1
    println!(
        "{}",
        num_distinct_islands(vec![
            vec![1, 1, 0, 1, 1],
            vec![1, 0, 0, 0, 0],
            vec![0, 0, 0, 0, 1],
            vec![1, 1, 0, 1, 1]
        ])
    ); // 3
    println!(
        "{}",
        num_distinct_islands(vec![
            vec![
                0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0,
                0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0
            ],
            vec![
                0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1,
                0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0
            ],
            vec![
                0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0,
                0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0
            ],
            vec![
                1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1,
                0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1
            ]
        ])
    ); // 15
    println!(
        "{}",
        num_distinct_islands(vec![
            vec![
                0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0,
                0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0
            ],
            vec![
                0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0,
                0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0
            ]
        ])
    ); // 9
    println!(
        "{}",
        num_distinct_islands(vec![vec![1, 1, 0, 1, 1], vec![0, 1, 0, 1, 0]])
    ); // 2
}
