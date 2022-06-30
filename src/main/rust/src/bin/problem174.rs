// https://leetcode.com/problems/dungeon-game/
pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
    fn f(dungeon: &Vec<Vec<i32>>, row: i32, col: i32, sum: i32, health: i32) -> i32 {
        let max_rows = dungeon.len() as i32;
        let max_cols = if max_rows > 0 { dungeon[0].len() } else { 0 } as i32;
        let value = &dungeon[row as usize][col as usize];
        let health = if sum + value <= 0 {
            (sum + value).abs() + 1
        } else {
            health
        };
        if row == max_rows - 1 && col == max_cols - 1 {
            return health;
        }
        let mut min = i32::MAX;
        if col + 1 < max_cols {
            let right = f(dungeon, row, col + 1, sum + value, health);
            min = min.min(right);
        }
        if row + 1 < max_rows {
            let down = f(dungeon, row + 1, col, sum + value, health);
            min = min.min(down);
        }
        min
    }

    f(&dungeon, 0, 0, 0, 1)
}

fn main() {
    println!(
        "{}",
        calculate_minimum_hp(vec![vec![-2, -3, 3], vec![-5, -10, 1], vec![10, 30, -5]])
    ); // 7
    println!(
        "{}",
        calculate_minimum_hp(vec![vec![2, 3, 3], vec![5, 10, 1], vec![10, 30, 5]])
    ); // 1
    println!(
        "{}",
        calculate_minimum_hp(vec![vec![2, -3, 3], vec![-5, -10, 1], vec![10, 30, -5]])
    ); // 3
    println!(
        "{}",
        calculate_minimum_hp(vec![vec![2, 3, 3], vec![-5, -10, 1], vec![10, 30, 5]])
    ); // 1
    println!("{}", calculate_minimum_hp(vec![vec![0]])); // 1
}
