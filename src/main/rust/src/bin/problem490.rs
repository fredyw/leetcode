// https://leetcode.com/problems/the-maze/description/
pub fn has_path(maze: Vec<Vec<i32>>, start: Vec<i32>, destination: Vec<i32>) -> bool {
    fn has_path(
        maze: &Vec<Vec<i32>>,
        start: (i32, i32),
        destination: (i32, i32),
        visited: &mut Vec<Vec<bool>>,
    ) -> bool {
        let num_rows = maze.len() as i32;
        let num_cols = if num_rows > 0 { maze[0].len() } else { 0 } as i32;
        let (row, col) = start;
        if visited[row as usize][col as usize] {
            return false;
        }
        visited[row as usize][col as usize] = true;
        let mut found = row == destination.0 && col == destination.1;
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            let mut new_row = row + r;
            let mut new_col = col + c;
            while new_row >= 0
                && new_row < num_rows
                && new_col >= 0
                && new_col < num_cols
                && maze[new_row as usize][new_col as usize] == 0
            {
                new_row += r;
                new_col += c;
            }
            new_row -= r;
            new_col -= c;
            found |= has_path(maze, (new_row, new_col), destination, visited);
        }
        found
    }

    let num_rows = maze.len();
    let num_cols = if num_rows > 0 { maze[0].len() } else { 0 };
    has_path(
        &maze,
        (start[0], start[1]),
        (destination[0], destination[1]),
        &mut vec![vec![false; num_cols]; num_rows],
    )
}

fn main() {
    println!(
        "{}",
        has_path(
            vec![
                vec![0, 0, 1, 0, 0],
                vec![0, 0, 0, 0, 0],
                vec![0, 0, 0, 1, 0],
                vec![1, 1, 0, 1, 1],
                vec![0, 0, 0, 0, 0]
            ],
            vec![0, 4],
            vec![4, 4]
        )
    ); // true
    println!(
        "{}",
        has_path(
            vec![
                vec![0, 0, 1, 0, 0],
                vec![0, 0, 0, 0, 0],
                vec![0, 0, 0, 1, 0],
                vec![1, 1, 0, 1, 1],
                vec![0, 0, 0, 0, 0]
            ],
            vec![0, 4],
            vec![3, 2]
        )
    ); // false
    println!(
        "{}",
        has_path(
            vec![
                vec![0, 0, 0, 0, 0],
                vec![1, 1, 0, 0, 1],
                vec![0, 0, 0, 0, 0],
                vec![0, 1, 0, 0, 1],
                vec![0, 1, 0, 0, 0]
            ],
            vec![4, 3],
            vec![0, 1]
        )
    ); // false
    println!(
        "{}",
        has_path(
            vec![
                vec![0, 0, 1, 0, 0],
                vec![0, 0, 0, 0, 0],
                vec![0, 0, 0, 1, 0],
                vec![1, 1, 0, 1, 1],
                vec![0, 0, 0, 0, 0]
            ],
            vec![0, 4],
            vec![2, 1]
        )
    ); // true
}
