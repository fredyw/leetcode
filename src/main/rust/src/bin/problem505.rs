// https://leetcode.com/problems/the-maze-ii/description/
pub fn shortest_distance(maze: Vec<Vec<i32>>, start: Vec<i32>, destination: Vec<i32>) -> i32 {
    fn shortest_distance(maze: &Vec<Vec<i32>>, start: (i32, i32), distance: &mut Vec<Vec<i32>>) {
        let num_rows = maze.len() as i32;
        let num_cols = if num_rows > 0 { maze[0].len() } else { 0 } as i32;
        let (row, col) = start;
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            let mut new_row = row + r;
            let mut new_col = col + c;
            let mut count = 0;
            while new_row >= 0
                && new_row < num_rows
                && new_col >= 0
                && new_col < num_cols
                && maze[new_row as usize][new_col as usize] == 0
            {
                new_row += r;
                new_col += c;
                count += 1;
            }
            new_row -= r;
            new_col -= c;
            if distance[row as usize][col as usize] + count
                < distance[new_row as usize][new_col as usize]
            {
                distance[new_row as usize][new_col as usize] =
                    distance[row as usize][col as usize] + count;
                shortest_distance(maze, (new_row, new_col), distance);
            }
        }
    }

    let num_rows = maze.len();
    let num_cols = if num_rows > 0 { maze[0].len() } else { 0 };
    let mut distance = vec![vec![i32::MAX; num_cols]; num_rows];
    distance[start[0] as usize][start[1] as usize] = 0;
    shortest_distance(&maze, (start[0], start[1]), &mut distance);
    if distance[destination[0] as usize][destination[1] as usize] == i32::MAX {
        -1
    } else {
        distance[destination[0] as usize][destination[1] as usize]
    }
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
    println!(
        "{}",
        shortest_distance(vec![vec![0, 1], vec![0, 0]], vec![0, 0], vec![1, 1])
    ); // 2
    println!(
        "{}",
        shortest_distance(vec![vec![0, 0], vec![0, 0]], vec![0, 0], vec![1, 1])
    ); // 2
    println!(
        "{}",
        shortest_distance(vec![vec![0, 0]], vec![0, 0], vec![0, 1])
    ); // 1
    println!(
        "{}",
        shortest_distance(vec![vec![0, 0], vec![0, 0]], vec![0, 0], vec![1, 0])
    ); // 1
}
