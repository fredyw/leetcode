// https://leetcode.com/problems/the-maze-ii/description/
pub fn shortest_distance(maze: Vec<Vec<i32>>, start: Vec<i32>, destination: Vec<i32>) -> i32 {
    fn shortest_distance(
        maze: &Vec<Vec<i32>>,
        start: (i32, i32),
        destination: (i32, i32),
        visited: &mut Vec<Vec<bool>>,
    ) -> Option<i32> {
        let num_rows = maze.len() as i32;
        let num_cols = if num_rows > 0 { maze[0].len() } else { 0 } as i32;
        let (row, col) = start;
        if visited[row as usize][col as usize] {
            return None;
        }
        visited[row as usize][col as usize] = true;
        if row == destination.0 && col == destination.1 {
            return Some(0);
        }
        // up
        let mut num_moves = 0;
        let mut r = row;
        while r - 1 >= 0 && maze[r as usize - 1][col as usize] == 0 {
            num_moves += 1;
            r -= 1;
        }
        let up = if let Some(d) = shortest_distance(maze, (r, col), destination, visited) {
            d + num_moves
        } else {
            i32::MAX
        };
        // right
        let mut num_moves = 0;
        let mut c = col;
        while c + 1 < num_cols && maze[row as usize][c as usize + 1] == 0 {
            num_moves += 1;
            c += 1;
        }
        let right = if let Some(d) = shortest_distance(maze, (row, c), destination, visited) {
            d + num_moves
        } else {
            i32::MAX
        };
        // down
        let mut num_moves = 0;
        let mut r = row;
        while r + 1 < num_rows && maze[r as usize + 1][col as usize] == 0 {
            num_moves += 1;
            r += 1;
        }
        let down = if let Some(d) = shortest_distance(maze, (r, col), destination, visited) {
            d + num_moves
        } else {
            i32::MAX
        };
        // left
        let mut num_moves = 0;
        let mut c = col;
        while c - 1 >= 0 && maze[row as usize][c as usize - 1] == 0 {
            num_moves += 1;
            c -= 1;
        }
        let left = if let Some(d) = shortest_distance(maze, (row, c), destination, visited) {
            d + num_moves
        } else {
            i32::MAX
        };
        visited[row as usize][col as usize] = false;
        let min = up.min(right.min(down.min(left)));
        if min == i32::MAX {
            None
        } else {
            Some(min)
        }
    }

    let num_rows = maze.len();
    let num_cols = if num_rows > 0 { maze[0].len() } else { 0 };
    shortest_distance(
        &maze,
        (start[0], start[1]),
        (destination[0], destination[1]),
        &mut vec![vec![false; num_cols]; num_rows],
    )
    .unwrap_or(-1)
}

fn main() {
    // println!(
    //     "{}",
    //     shortest_distance(
    //         vec![
    //             vec![0, 0, 1, 0, 0],
    //             vec![0, 0, 0, 0, 0],
    //             vec![0, 0, 0, 1, 0],
    //             vec![1, 1, 0, 1, 1],
    //             vec![0, 0, 0, 0, 0]
    //         ],
    //         vec![0, 4],
    //         vec![4, 4]
    //     )
    // ); // 12
    // println!(
    //     "{}",
    //     shortest_distance(
    //         vec![
    //             vec![0, 0, 1, 0, 0],
    //             vec![0, 0, 0, 0, 0],
    //             vec![0, 0, 0, 1, 0],
    //             vec![1, 1, 0, 1, 1],
    //             vec![0, 0, 0, 0, 0]
    //         ],
    //         vec![0, 4],
    //         vec![3, 2]
    //     )
    // ); // -1
    // println!(
    //     "{}",
    //     shortest_distance(
    //         vec![
    //             vec![0, 0, 0, 0, 0],
    //             vec![1, 1, 0, 0, 1],
    //             vec![0, 0, 0, 0, 0],
    //             vec![0, 1, 0, 0, 1],
    //             vec![0, 1, 0, 0, 0]
    //         ],
    //         vec![4, 3],
    //         vec![0, 1]
    //     )
    // ); // -1
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
            vec![2, 1]
        )
    ); // 9
       // println!(
       //     "{}",
       //     shortest_distance(vec![vec![0, 1], vec![0, 0]], vec![0, 0], vec![1, 1])
       // ); // 2
       // println!(
       //     "{}",
       //     shortest_distance(vec![vec![0, 0], vec![0, 0]], vec![0, 0], vec![1, 1])
       // ); // 2
       // println!(
       //     "{}",
       //     shortest_distance(vec![vec![0, 0]], vec![0, 0], vec![0, 1])
       // ); // 1
}
