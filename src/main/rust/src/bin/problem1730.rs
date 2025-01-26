use std::collections::VecDeque;

// https://leetcode.com/problems/shortest-path-to-get-food/description/
pub fn get_food(grid: Vec<Vec<char>>) -> i32 {
    fn get_person_index(grid: &Vec<Vec<char>>) -> (i32, i32) {
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == '*' {
                    return (i as i32, j as i32);
                }
            }
        }
        (-1, -1)
    }

    let mut answer = i32::MAX;
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let (row, col) = get_person_index(&grid);
    let mut deque: VecDeque<(i32, i32)> = VecDeque::new();
    deque.push_back((row, col));
    let mut visited = vec![vec![false; num_cols]; num_rows];
    let mut length = 0;
    while !deque.is_empty() {
        let n = deque.len();
        for _ in 0..n {
            let (row, col) = deque.pop_front().unwrap();
            if row < 0
                || row == num_rows as i32
                || col < 0
                || col == num_cols as i32
                || grid[row as usize][col as usize] == 'X'
                || visited[row as usize][col as usize]
            {
                continue;
            }
            visited[row as usize][col as usize] = true;
            if grid[row as usize][col as usize] == '#' {
                answer = answer.min(length);
            }
            for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
                deque.push_back((row + r, col + c));
            }
        }
        length += 1;
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    println!(
        "{}",
        get_food(vec![
            vec!['X', 'X', 'X', 'X', 'X', 'X'],
            vec!['X', '*', 'O', 'O', 'O', 'X'],
            vec!['X', 'O', 'O', '#', 'O', 'X'],
            vec!['X', 'X', 'X', 'X', 'X', 'X']
        ])
    ); // 3
    println!(
        "{}",
        get_food(vec![
            vec!['X', 'X', 'X', 'X', 'X'],
            vec!['X', '*', 'X', 'O', 'X'],
            vec!['X', 'O', 'X', '#', 'X'],
            vec!['X', 'X', 'X', 'X', 'X']
        ])
    ); // -1
    println!(
        "{}",
        get_food(vec![
            vec!['X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'],
            vec!['X', '*', 'O', 'X', 'O', '#', 'O', 'X'],
            vec!['X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'],
            vec!['X', 'O', 'O', 'O', 'O', '#', 'O', 'X'],
            vec!['X', 'X', 'X', 'X', 'X', 'X', 'X', 'X']
        ])
    ); // 6
}
