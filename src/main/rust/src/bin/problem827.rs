// https://leetcode.com/problems/making-a-large-island/description/
pub fn largest_island(grid: Vec<Vec<i32>>) -> i32 {
    fn largest_island(
        grid: &Vec<Vec<i32>>,
        row: i32,
        col: i32,
        change: bool,
        visited: &mut Vec<Vec<bool>>,
    ) -> i32 {
        let n = grid.len() as i32;
        let mut max = 0;
        visited[row as usize][col as usize] = true;
        for (r, c) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
            let next_row = row + r;
            let next_col = col + c;
            if next_row < 0
                || next_col < 0
                || next_row == n
                || next_col == n
                || visited[next_row as usize][next_col as usize]
            {
                continue;
            }
            if grid[next_row as usize][next_col as usize] == 0 {
                if !change {
                    let update = largest_island(grid, next_row, next_col, !change, visited) + 1;
                    let skip = largest_island(grid, next_row, next_col, change, visited);
                    max = max.max(update.max(skip));
                } else {
                    max = max.max(largest_island(grid, next_row, next_col, change, visited));
                }
            } else {
                max = max.max(largest_island(grid, next_row, next_col, change, visited) + 1);
            }
        }
        visited[row as usize][col as usize] = false;
        max
    }

    let mut answer = 0;
    let n = grid.len();
    for row in 0..n {
        for col in 0..n {
            let mut visited = vec![vec![false; n]; n];
            if grid[row][col] == 0 {
                let update = largest_island(&grid, row as i32, col as i32, true, &mut visited) + 1;
                let skip = largest_island(&grid, row as i32, col as i32, false, &mut visited);
                answer = answer.max(update.max(skip));
            } else {
                answer = answer
                    .max(largest_island(&grid, row as i32, col as i32, false, &mut visited) + 1);
            }
            println!("answer: {}", answer);
        }
    }
    answer
}

fn main() {
    println!("{}", largest_island(vec![vec![1, 0], vec![0, 1]])); // 3
    println!("{}", largest_island(vec![vec![1, 1], vec![1, 0]])); // 4
    println!("{}", largest_island(vec![vec![1, 1], vec![1, 1]])); // 4
    println!("{}", largest_island(vec![vec![0, 0], vec![0, 0]])); // 1
    println!("{}", largest_island(vec![vec![0, 0], vec![1, 0]])); // 2
}
