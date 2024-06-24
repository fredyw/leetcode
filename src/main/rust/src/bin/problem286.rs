use std::collections::VecDeque;

// https://leetcode.com/problems/walls-and-gates/
pub fn walls_and_gates(rooms: &mut Vec<Vec<i32>>) {
    fn bfs(rooms: &mut Vec<Vec<i32>>, row: i32, col: i32) {
        let max_row = rooms.len() as i32;
        let max_col = if max_row > 0 {
            rooms[0].len() as i32
        } else {
            0
        };
        let mut visited: Vec<Vec<bool>> = vec![vec![false; max_col as usize]; max_row as usize];
        let mut deque: VecDeque<(i32, i32, i32)> = VecDeque::new();
        deque.push_back((row, col, 0));
        while let Some(&(current_row, current_col, current_distance)) = deque.front() {
            let size = deque.len();
            deque.pop_front();
            if visited[current_row as usize][current_col as usize] {
                continue;
            }
            visited[current_row as usize][current_col as usize] = true;
            rooms[current_row as usize][current_col as usize] =
                rooms[current_row as usize][current_col as usize].min(current_distance);
            for _ in 0..size {
                for (r, c) in [(0, -1), (0, 1), (-1, 0), (1, 0)] {
                    let next_row = current_row + r;
                    let next_col = current_col + c;
                    if next_row < 0
                        || next_col < 0
                        || next_row == max_row
                        || next_col == max_col
                        || rooms[next_row as usize][next_col as usize] == -1
                        || rooms[next_row as usize][next_col as usize] == 0
                    {
                        continue;
                    }
                    deque.push_back((next_row, next_col, current_distance + 1));
                }
            }
        }
    }

    for row in 0..rooms.len() {
        for col in 0..rooms[row].len() {
            if rooms[row][col] == 0 {
                bfs(rooms, row as i32, col as i32);
            }
        }
    }
}

fn main() {
    let mut rooms = vec![
        vec![2147483647, -1, 0, 2147483647],
        vec![2147483647, 2147483647, 2147483647, -1],
        vec![2147483647, -1, 2147483647, -1],
        vec![0, -1, 2147483647, 2147483647],
    ];
    walls_and_gates(&mut rooms);
    println!("{:?}", rooms); // [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]

    let mut rooms = vec![vec![-1]];
    walls_and_gates(&mut rooms);
    println!("{:?}", rooms); // [[-1]]

    let mut rooms = vec![
        vec![2147483647, -1, 0, 2147483647],
        vec![2147483647, 2147483647, 2147483647, -1],
        vec![2147483647, -1, 2147483647, -1],
        vec![0, -1, 2147483647, 0],
    ];
    walls_and_gates(&mut rooms);
    println!("{:?}", rooms); // [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,1,0]]
}
