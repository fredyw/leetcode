// https://leetcode.com/problems/sum-of-remoteness-of-all-cells/description/
pub fn sum_remoteness(grid: Vec<Vec<i32>>) -> i64 {
    fn traverse(grid: &Vec<Vec<i32>>, row: i32, col: i32, visited: &mut Vec<Vec<bool>>) {
        let n = grid.len() as i32;
        if row < 0
            || row == n
            || col < 0
            || col == n
            || grid[row as usize][col as usize] == -1
            || visited[row as usize][col as usize]
        {
            return;
        }
        visited[row as usize][col as usize] = true;
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            traverse(grid, row + r, col + c, visited);
        }
    }

    let n = grid.len();
    let mut visited = vec![vec![false; n]; n];
    let mut connected_components: Vec<Vec<i32>> = vec![vec![]; n];
    for row in 0..n {
        for col in 0..n {
            if grid[row][col] == -1 || visited[row][col] {
                continue;
            }
        }
    }
    todo!()
}

fn main() {
    println!(
        "{}",
        sum_remoteness(vec![vec![-1, 1, -1], vec![5, -1, 4], vec![-1, 3, -1]])
    ); // 39
    println!(
        "{}",
        sum_remoteness(vec![vec![-1, 3, 4], vec![-1, -1, -1], vec![3, -1, -1]])
    ); // 13
    println!("{}", sum_remoteness(vec![vec![1]])); // 0
}
