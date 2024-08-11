// https://leetcode.com/problems/snake-in-matrix/description/
pub fn final_position_of_snake(n: i32, commands: Vec<String>) -> i32 {
    let mut grid: Vec<Vec<i32>> = vec![vec![0; n as usize]; n as usize];
    let mut num = 0;
    for i in 0..grid.len() {
        for j in 0..grid[0].len() {
            grid[i][j] = num;
            num += 1;
        }
    }
    let mut row = 0;
    let mut col = 0;
    for command in commands {
        match command.as_str() {
            "UP" => row -= 1,
            "RIGHT" => col += 1,
            "DOWN" => row += 1,
            _ => col -= 1,
        }
    }
    grid[row][col]
}

fn main() {
    println!(
        "{}",
        final_position_of_snake(2, vec!["RIGHT".to_string(), "DOWN".to_string()])
    ); // 3
    println!(
        "{}",
        final_position_of_snake(
            3,
            vec!["DOWN".to_string(), "RIGHT".to_string(), "UP".to_string()]
        )
    ); // 1
}
