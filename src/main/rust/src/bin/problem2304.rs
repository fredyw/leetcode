use std::cmp;

// https://leetcode.com/problems/minimum-path-cost-in-a-grid/
pub fn min_path_cost(grid: Vec<Vec<i32>>, move_cost: Vec<Vec<i32>>) -> i32 {
    fn f(
        grid: &Vec<Vec<i32>>,
        move_cost: &Vec<Vec<i32>>,
        row: i32,
        col: i32,
        memo: &mut Vec<Vec<i32>>,
    ) -> i32 {
        let max_row = grid.len() as i32;
        let max_col = if max_row < 0 { 0 } else { grid[0].len() } as i32;
        if row == max_row || col == max_col {
            return 0;
        }
        if memo[row as usize][col as usize] != -1 {
            return memo[row as usize][col as usize];
        }
        let value = grid[row as usize][col as usize];
        let mut min = i32::MAX;
        for (i, cost) in move_cost[value as usize].iter().enumerate() {
            let cost = if row == max_row - 1 { 0 } else { *cost };
            min = cmp::min(
                min,
                f(grid, move_cost, row + 1, i as i32, memo) + value + cost,
            );
        }
        memo[row as usize][col as usize] = min;
        min
    }
    let mut answer = i32::MAX;
    let max_row = grid.len() as i32;
    let max_col = if max_row < 0 { 0 } else { grid[0].len() } as i32;
    let mut memo = vec![vec![-1; max_col as usize]; max_row as usize];
    for i in 0..grid[0].len() {
        answer = cmp::min(answer, f(&grid, &move_cost, 0, i as i32, &mut memo));
    }
    answer
}

fn main() {
    println!(
        "{}",
        min_path_cost(
            vec![vec![5, 3], vec![4, 0], vec![2, 1]],
            vec![
                vec![9, 8],
                vec![1, 5],
                vec![10, 12],
                vec![18, 6],
                vec![2, 4],
                vec![14, 3]
            ]
        )
    ); // 17
    println!(
        "{}",
        min_path_cost(
            vec![vec![5, 1, 2], vec![4, 0, 3]],
            vec![
                vec![12, 10, 15], // 0
                vec![20, 23, 8],  // 1
                vec![21, 7, 1],   // 2
                vec![8, 1, 13],   // 3
                vec![9, 10, 25],  // 4
                vec![5, 3, 2]     // 5
            ]
        )
    ); // 6
}
