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
    while let Some(Reverse((dist, src_row, src_col))) = heap.pop() {
        if visited[src_row][src_col] {
            continue;
        }
        visited[src_row as usize][src_col as usize] = true;
        for (r, c) in [(-1, 0), (1, 0), (0, -1), (0, 1)].iter() {
            let row = src_row as isize + r;
            let col = src_col as isize + c;
            if row < 0 || col < 0 || row == num_rows as isize || col == num_cols as isize {
                continue;
            }
            if let Some(dist) = distance[src_row as usize][src_col as usize] {
                let new_dist = dist.max(move_time[row as usize][col as usize]) + 1;
                if distance[row as usize][col as usize].unwrap_or(i32::MAX) > new_dist {
                    distance[row as usize][col as usize] = Some(new_dist);
                    heap.push(Reverse((new_dist, row as usize, col as usize)));
                }
            } else {
                todo!()
            }
        }
    }
    distance[num_rows - 1][num_cols].unwrap()
}

fn main() {
    println!("{}", min_time_to_reach(vec![vec![0, 4], vec![4, 4]])); // 6
    println!("{}", min_time_to_reach(vec![vec![0, 0, 0], vec![0, 0, 0]])); // 3
    println!("{}", min_time_to_reach(vec![vec![0, 1], vec![1, 2]])); // 3
}
