// https://leetcode.com/problems/the-maze-ii/description/
pub fn shortest_distance(maze: Vec<Vec<i32>>, start: Vec<i32>, destination: Vec<i32>) -> i32 {
    fn shortest_distance(
        maze: &Vec<Vec<i32>>,
        start: (i32, i32),
        destination: (i32, i32),
        visited: &mut Vec<Vec<bool>>,
    ) -> i32 {
        let num_rows = maze.len() as i32;
        let num_cols = if num_rows > 0 { maze[0].len() } else { 0 } as i32;
        let (row, col) = start;
        if row < 0 || row == num_rows || col < 0 || col == num_cols {
            return 0;
        }
        if visited[row as usize][col as usize] {
            return 0;
        }
        visited[row as usize][col as usize] = true;
        let found = row == destination.0 && col == destination.1;
        // up
        let mut r = row;
        while r >= 0 && maze[r as usize][col as usize] == 0 {
            r -= 1;
        }
        let up = shortest_distance(maze, (r + 1, col), destination, visited);
        // right
        let mut c = col;
        while c < num_cols && maze[row as usize][c as usize] == 0 {
            c += 1;
        }
        let right = shortest_distance(maze, (row, c - 1), destination, visited);
        // down
        let mut r = row;
        while r < num_rows && maze[r as usize][col as usize] == 0 {
            r += 1;
        }
        let down = shortest_distance(maze, (r - 1, col), destination, visited);
        // left
        let mut c = col;
        while c >= 0 && maze[row as usize][c as usize] == 0 {
            c -= 1;
        }
        let left = shortest_distance(maze, (row, c + 1), destination, visited);
        let min = up.min(right.min(down.min(left)));
        min
    }

    let num_rows = maze.len();
    let num_cols = if num_rows > 0 { maze[0].len() } else { 0 };
    shortest_distance(
        &maze,
        (start[0], start[1]),
        (destination[0], destination[1]),
        &mut vec![vec![false; num_cols]; num_rows],
    )
}

fn main() {
    println!(
        "{}",
        shortest_distance(
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
    ); // 12
    println!(
        "{}",
        shortest_distance(
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
    ); // -1
    println!(
        "{}",
        shortest_distance(
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
    ); // -1
}
