use std::cmp::Reverse;
use std::collections::BinaryHeap;

// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/
pub fn min_time_to_reach(move_time: Vec<Vec<i32>>) -> i32 {
    let num_rows = move_time.len();
    let num_cols = if num_rows > 0 { move_time[0].len() } else { 0 };
    let mut visited: Vec<Vec<bool>> = vec![vec![false; num_cols]; num_rows];
    let mut distance: Vec<Vec<Option<i32>>> = vec![vec![None; num_cols]; num_rows];
    distance[0][0] = Some(0);
    let mut heap: BinaryHeap<Reverse<(i32, usize, usize)>> = BinaryHeap::new();
    heap.push(Reverse((0, 0, 0)));
    while let Some(Reverse((_, row, col))) = heap.pop() {
        if visited[row][col] {
            continue;
        }
        visited[row][col] = true;
        for (r, c) in [(-1, 0), (1, 0), (0, -1), (0, 1)].iter() {
            let next_row = row as isize + r;
            let next_col = col as isize + c;
            if next_row < 0
                || next_col < 0
                || next_row == num_rows as isize
                || next_col == num_cols as isize
            {
                continue;
            }
            let new_dist = distance[row][col]
                .unwrap()
                .max(move_time[next_row as usize][next_col as usize])
                + 1;
            if let Some(dist) = distance[next_row as usize][next_col as usize] {
                if dist > new_dist {
                    distance[next_row as usize][next_col as usize] = Some(new_dist);
                    heap.push(Reverse((new_dist, next_row as usize, next_col as usize)));
                }
            } else {
                distance[next_row as usize][next_col as usize] = Some(new_dist);
                heap.push(Reverse((new_dist, next_row as usize, next_col as usize)));
            }
        }
    }
    distance[num_rows - 1][num_cols - 1].unwrap()
}

fn main() {
    println!("{}", min_time_to_reach(vec![vec![0, 4], vec![4, 4]])); // 6
    println!("{}", min_time_to_reach(vec![vec![0, 0, 0], vec![0, 0, 0]])); // 3
    println!("{}", min_time_to_reach(vec![vec![0, 1], vec![1, 2]])); // 3
}
