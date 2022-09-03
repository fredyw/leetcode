use std::collections::VecDeque;

// https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
pub fn nearest_exit(maze: Vec<Vec<char>>, entrance: Vec<i32>) -> i32 {
    let mut answer = 0;
    let mut found_exit = false;
    let max_rows = maze.len();
    let max_cols = if max_rows == 0 { 0 } else { maze[0].len() };
    let mut visited: Vec<Vec<bool>> = vec![vec![false; max_cols]; max_rows];
    let mut deque: VecDeque<Vec<i32>> = VecDeque::new();
    deque.push_back(entrance.clone());
    'outer: while !deque.is_empty() {
        let length = deque.len();
        for _ in 0..length {
            let v = deque.pop_front().unwrap();
            visited[v[0] as usize][v[1] as usize] = true;
            for (r, c) in vec![(-1, 0), (0, 1), (1, 0), (0, -1)] {
                let row = v[0] + r;
                let col = v[1] + c;
                if v[0] == entrance[0]
                    && v[1] == entrance[1]
                    && (row < 0 || row == max_rows as i32 || col < 0 || col == max_cols as i32)
                {
                    continue;
                }
                if row < 0 || row == max_rows as i32 || col < 0 || col == max_cols as i32 {
                    found_exit = true;
                    break 'outer;
                }
                if visited[row as usize][col as usize] {
                    continue;
                }
                if maze[row as usize][col as usize] == '+' {
                    continue;
                }
                deque.push_back(vec![v[0] + r, v[1] + c]);
            }
        }
        answer += 1;
    }
    if !found_exit {
        -1
    } else {
        answer
    }
}

fn main() {
    println!(
        "{}",
        nearest_exit(
            vec![
                vec!['+', '+', '.', '+'],
                vec!['.', '.', '.', '+'],
                vec!['+', '+', '+', '.']
            ],
            vec![1, 2]
        )
    ); // 1
    println!(
        "{}",
        nearest_exit(
            vec![
                vec!['+', '+', '+'],
                vec!['.', '.', '.'],
                vec!['+', '+', '+']
            ],
            vec![1, 0]
        )
    ); // 2
    println!("{}", nearest_exit(vec![vec!['.', '+']], vec![0, 0])); // -1
    println!(
        "{}",
        nearest_exit(
            vec![
                vec!['+', '.', '+', '+', '+', '+', '+'],
                vec!['+', '.', '+', '.', '.', '.', '+'],
                vec!['+', '.', '+', '.', '+', '.', '+'],
                vec!['+', '.', '.', '.', '+', '.', '+'],
                vec!['+', '+', '+', '+', '+', '+', '.']
            ],
            vec![0, 1]
        )
    ); // -1
}
