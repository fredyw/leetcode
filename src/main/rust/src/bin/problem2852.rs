use std::collections::HashMap;

// https://leetcode.com/problems/sum-of-remoteness-of-all-cells/description/
pub fn sum_remoteness(grid: Vec<Vec<i32>>) -> i64 {
    fn traverse(
        grid: &Vec<Vec<i32>>,
        row: i32,
        col: i32,
        id: i32,
        visited: &mut Vec<Vec<bool>>,
        connected_components: &mut Vec<Vec<i32>>,
        sum: &mut i64,
    ) {
        let n = grid.len() as i32;
        if row < 0
            || row == n
            || col < 0
            || col == n
            || grid[row as usize][col as usize] == -1
            || visited[row as usize][col as usize]
        {
            return;
        }
        visited[row as usize][col as usize] = true;
        connected_components[row as usize][col as usize] = id;
        *sum += grid[row as usize][col as usize] as i64;
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            traverse(
                grid,
                row + r,
                col + c,
                id,
                visited,
                connected_components,
                sum,
            );
        }
    }

    let n = grid.len();
    let mut visited = vec![vec![false; n]; n];
    let mut connected_components: Vec<Vec<i32>> = vec![vec![-1; n]; n];
    let mut sums: HashMap<i32, i64> = HashMap::new();
    let mut total_sum = 0;
    let mut id = 0;
    for row in 0..n {
        for col in 0..n {
            if grid[row][col] == -1 || visited[row][col] {
                continue;
            }
            let mut sum = 0;
            traverse(
                &grid,
                row as i32,
                col as i32,
                id,
                &mut visited,
                &mut connected_components,
                &mut sum,
            );
            total_sum += sum;
            sums.insert(id, sum);
            id += 1;
        }
    }
    let mut answer = 0;
    for connected in connected_components.iter() {
        for id in connected.iter() {
            if *id >= 0 {
                answer += total_sum - sums[id];
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        sum_remoteness(vec![vec![-1, 1, -1], vec![5, -1, 4], vec![-1, 3, -1]])
    ); // 39
    println!(
        "{}",
        sum_remoteness(vec![vec![-1, 3, 4], vec![-1, -1, -1], vec![3, -1, -1]])
    ); // 13
    println!("{}", sum_remoteness(vec![vec![1]])); // 0
}
