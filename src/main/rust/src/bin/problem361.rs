// https://leetcode.com/problems/bomb-enemy/description/
pub fn max_killed_enemies(grid: Vec<Vec<char>>) -> i32 {
    let mut answer = 0;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    for i in 0..num_rows {
        for j in 0..num_cols {
            if grid[i][j] == '0' {
                let mut count = 0;
                for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
                    let row = i as i32 + r;
                    let col = j as i32 + c;
                    if row < 0
                        || row == num_rows as i32
                        || col < 0
                        || col == num_cols as i32
                        || grid[row as usize][col as usize] == 'W'
                    {
                        continue;
                    }
                    if grid[row as usize][col as usize] == 'E' {
                        count += 1;
                    }
                }
                answer = answer.max(count);
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        max_killed_enemies(vec![
            vec!['0', 'E', '0', '0'],
            vec!['E', '0', 'W', 'E'],
            vec!['0', 'E', '0', '0']
        ])
    ); // 3
    println!(
        "{}",
        max_killed_enemies(vec![
            vec!['W', 'W', 'W'],
            vec!['0', '0', '0'],
            vec!['E', 'E', 'E']
        ])
    ); // 1
    println!(
        "{}",
        max_killed_enemies(vec![vec![
            '0', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'W'
        ]])
    ); // 1
}
