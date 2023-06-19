// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
pub fn find_max_fish(grid: Vec<Vec<i32>>) -> i32 {
    fn dfs(grid: &Vec<Vec<i32>>, row: i32, col: i32, visited: &mut Vec<Vec<bool>>) -> i32 {
        let max_rows = grid.len() as i32;
        let max_cols = if max_rows > 0 { grid[0].len() } else { 0 } as i32;
        if row < 0 || row == max_rows || col < 0 || col == max_cols {
            return 0;
        }
        if visited[row as usize][col as usize] {
            return 0;
        }
        if grid[row as usize][col as usize] == 0 {
            return 0;
        }
        visited[row as usize][col as usize] = true;
        let mut sum = grid[row as usize][col as usize];
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            sum += dfs(grid, row + r, col + c, visited);
        }
        sum
    }

    let mut answer = 0;
    let max_rows = grid.len();
    let max_cols = if max_rows > 0 { grid[0].len() } else { 0 };
    let mut visited = vec![vec![false; max_cols]; max_rows];
    for r in 0..max_rows {
        for c in 0..max_cols {
            if grid[r][c] == 0 || visited[r][c] {
                continue;
            }
            answer = answer.max(dfs(&grid, r as i32, c as i32, &mut visited));
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        find_max_fish(vec![
            vec![0, 2, 1, 0],
            vec![4, 0, 0, 3],
            vec![1, 0, 0, 4],
            vec![0, 3, 2, 0]
        ])
    ); // 7
    println!(
        "{}",
        find_max_fish(vec![
            vec![1, 0, 0, 0],
            vec![0, 0, 0, 0],
            vec![0, 0, 0, 0],
            vec![0, 0, 0, 1]
        ])
    ); // 1
}
