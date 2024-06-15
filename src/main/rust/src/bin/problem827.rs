// https://leetcode.com/problems/making-a-large-island/description/
pub fn largest_island(grid: Vec<Vec<i32>>) -> i32 {
    fn largest_island(
        grid: &Vec<Vec<i32>>,
        row: i32,
        col: i32,
        mut convert: bool,
        visited: &mut Vec<Vec<bool>>,
    ) -> i32 {
        let n = grid.len() as i32;
        let mut max = 0;
        if row < 0 || col < 0 || row == n || col == n {
            return 0;
        }
        if visited[row as usize][col as usize] {
            return 0;
        }
        visited[row as usize][col as usize] = true;
        if grid[row as usize][col as usize] == 0 {
            if convert {
                return 0;
            }
            convert = true;
        }
        let island = 1;
        for (r, c) in [(0, 1), (0, -1), (1, 0), (-1, 0)] {
            max = max.max(largest_island(grid, row + r, col + c, convert, visited) + island);
        }
        max
    }

    let mut answer = 0;
    let n = grid.len();
    for row in 0..n {
        for col in 0..n {
            let mut visited = vec![vec![false; n]; n];
            answer = answer.max(largest_island(
                &grid,
                row as i32,
                col as i32,
                false,
                &mut visited,
            ));
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
    println!(
        "{}",
        largest_island(vec![vec![1, 0, 1], vec![0, 0, 0], vec![0, 1, 1]])
    ); // 4
    println!(
        "{}",
        largest_island(vec![
            vec![0, 0, 0, 0, 0, 0, 0],
            vec![0, 1, 1, 1, 1, 0, 0],
            vec![0, 1, 0, 0, 1, 0, 0],
            vec![1, 0, 1, 0, 1, 0, 0],
            vec![0, 1, 0, 0, 1, 0, 0],
            vec![0, 1, 0, 0, 1, 0, 0],
            vec![0, 1, 1, 1, 1, 0, 0]
        ])
    ); // 18
}
