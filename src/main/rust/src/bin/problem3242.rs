use std::collections::HashMap;

// https://leetcode.com/problems/design-neighbor-sum-service/
struct NeighborSum {
    grid: Vec<Vec<i32>>,
    row_cols: HashMap<i32, (usize, usize)>,
    num_rows: isize,
    num_cols: isize,
}

impl NeighborSum {
    fn new(grid: Vec<Vec<i32>>) -> Self {
        let num_rows = grid.len();
        let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
        let mut row_cols = HashMap::new();
        for i in 0..num_rows {
            for j in 0..num_cols {
                row_cols.insert(grid[i][j], (i, j));
            }
        }
        NeighborSum {
            grid,
            row_cols,
            num_rows: num_rows as isize,
            num_cols: num_cols as isize,
        }
    }

    fn adjacent_sum(&self, value: i32) -> i32 {
        let (row, col) = self.row_cols.get(&value).unwrap();
        let mut sum = 0;
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            let row = *row as isize + r;
            let col = *col as isize + c;
            if row >= 0 && col >= 0 && row < self.num_rows && col < self.num_cols {
                sum += self.grid[row as usize][col as usize];
            }
        }
        sum
    }

    fn diagonal_sum(&self, value: i32) -> i32 {
        let (row, col) = self.row_cols.get(&value).unwrap();
        let mut sum = 0;
        for (r, c) in [(-1, 1), (1, 1), (1, -1), (-1, -1)] {
            let row = *row as isize + r;
            let col = *col as isize + c;
            if row >= 0 && col >= 0 && row < self.num_rows && col < self.num_cols {
                sum += self.grid[row as usize][col as usize];
            }
        }
        sum
    }
}

fn main() {
    let neighbor_sum = NeighborSum::new(vec![vec![0, 1, 2], vec![3, 4, 5], vec![6, 7, 8]]);
    println!("{}", neighbor_sum.adjacent_sum(1)); // 6
    println!("{}", neighbor_sum.adjacent_sum(4)); // 16
    println!("{}", neighbor_sum.diagonal_sum(4)); // 16
    println!("{}", neighbor_sum.diagonal_sum(8)); // 4

    let neighbor_sum = NeighborSum::new(vec![
        vec![1, 2, 0, 3],
        vec![4, 7, 15, 6],
        vec![8, 9, 10, 11],
        vec![12, 13, 14, 5],
    ]);
    println!("{}", neighbor_sum.adjacent_sum(15)); // 23
    println!("{}", neighbor_sum.diagonal_sum(9)); // 45
}
