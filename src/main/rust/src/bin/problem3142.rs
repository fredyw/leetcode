// https://leetcode.com/problems/check-if-grid-satisfies-conditions/description/
pub fn satisfies_conditions(grid: Vec<Vec<i32>>) -> bool {
    for i in 0..grid.len() {
        for j in 0..grid[0].len() {
            if i + 1 < grid.len() && grid[i][j] != grid[i + 1][j] {
                return false;
            }
            if j + 1 < grid[i].len() && grid[i][j] == grid[i][j + 1] {
                return false;
            }
        }
    }
    true
}

fn main() {
    println!(
        "{}",
        satisfies_conditions(vec![vec![1, 0, 2], vec![1, 0, 2]])
    ); // true
    println!(
        "{}",
        satisfies_conditions(vec![vec![1, 1, 1], vec![0, 0, 0]])
    ); // false
    println!("{}", satisfies_conditions(vec![vec![1], vec![2], vec![3]])); // false
}
