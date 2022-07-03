// https://leetcode.com/problems/dungeon-game/
pub fn calculate_minimum_hp(dungeon: Vec<Vec<i32>>) -> i32 {
    fn f(dungeon: &Vec<Vec<i32>>, row: i32, col: i32, memo: &mut Vec<Vec<i32>>) -> i32 {
        let max_rows = dungeon.len() as i32;
        let max_cols = if max_rows > 0 { dungeon[0].len() } else { 0 } as i32;
        if row == max_rows || col == max_cols {
            return i32::MAX;
        }
        if memo[row as usize][col as usize] != -1 {
            return memo[row as usize][col as usize];
        }
        let value = &dungeon[row as usize][col as usize];
        if row == max_rows - 1 && col == max_cols - 1 {
            return if *value <= 0 { -value + 1 } else { 1 };
        }
        let right = f(dungeon, row, col + 1, memo);
        let down = f(dungeon, row + 1, col, memo);
        let min = right.min(down) - value;
        let min = if min <= 0 { 1 } else { min };
        memo[row as usize][col as usize] = min;
        min
    }

    let max_rows = dungeon.len() as i32;
    let max_cols = if max_rows > 0 { dungeon[0].len() } else { 0 } as i32;
    f(
        &dungeon,
        0,
        0,
        &mut vec![vec![-1; max_cols as usize]; max_rows as usize],
    )
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
