use std::collections::HashSet;

// https://leetcode.com/problems/difference-of-number-of-distinct-values-on-diagonals/
pub fn difference_of_distinct_values(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    let num_rows = grid.len();
    let num_cols = if num_rows > 0 { grid[0].len() } else { 0 };
    let mut prefix: Vec<Vec<i32>> = vec![vec![0; num_cols]; num_rows];
    let mut suffix: Vec<Vec<i32>> = vec![vec![0; num_cols]; num_rows];
    for row in 0..num_rows {
        let mut r = row;
        let mut c: usize = 0;
        let mut set: HashSet<i32> = HashSet::new();
        while r < num_rows && c < num_cols {
            set.insert(grid[r][c]);
            prefix[r][c] = set.len() as i32;
            r += 1;
            c += 1;
        }
    }
    for col in 0..num_cols {
        let mut r = 0;
        let mut c: usize = col;
        let mut set: HashSet<i32> = HashSet::new();
        while r < num_rows && c < num_cols {
            set.insert(grid[r][c]);
            prefix[r][c] = set.len() as i32;
            r += 1;
            c += 1;
        }
    }
    for row in (0..num_rows).rev() {
        let mut r = row as i32;
        let mut c = num_cols as i32 - 1;
        let mut set: HashSet<i32> = HashSet::new();
        while r >= 0 && c >= 0 {
            set.insert(grid[r as usize][c as usize]);
            suffix[r as usize][c as usize] = set.len() as i32;
            r -= 1;
            c -= 1;
        }
    }
    for col in (0..num_cols).rev() {
        let mut r = num_rows as i32 - 1;
        let mut c = col as i32;
        let mut set: HashSet<i32> = HashSet::new();
        while r >= 0 && c >= 0 {
            set.insert(grid[r as usize][c as usize]);
            suffix[r as usize][c as usize] = set.len() as i32;
            r -= 1;
            c -= 1;
        }
    }
    let mut answer = vec![vec![0; num_cols]; num_rows];
    for r in 0..num_rows as i32 {
        for c in 0..num_cols as i32 {
            let top_left = if r - 1 < 0 || c - 1 < 0 {
                0
            } else {
                prefix[r as usize - 1][c as usize - 1]
            };
            let bottom_right = if r + 1 == num_rows as i32 || c + 1 == num_cols as i32 {
                0
            } else {
                suffix[r as usize + 1][c as usize + 1]
            };
            answer[r as usize][c as usize] = (top_left - bottom_right).abs();
        }
    }
    answer
}

fn main() {
    println!(
        "{:?}",
        difference_of_distinct_values(vec![vec![1, 2, 3], vec![3, 1, 5], vec![3, 2, 1]])
    ); // [[1,1,0],[1,0,1],[0,1,1]]
    println!("{:?}", difference_of_distinct_values(vec![vec![1]])); // [[0]]
}
