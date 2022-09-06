use std::collections::VecDeque;

// https://leetcode.com/problems/maximum-rows-covered-by-columns/
pub fn maximum_rows(matrix: Vec<Vec<i32>>, num_select: i32) -> i32 {
    fn f(
        mat: &Vec<Vec<i32>>,
        num_cols: usize,
        index: usize,
        prefix_sums: &Vec<i32>,
        cols: &mut VecDeque<usize>,
    ) -> i32 {
        if cols.len() == num_cols {
            let mut num_rows = 0;
            for row in 0..mat.len() {
                let mut sum = prefix_sums[row];
                for col in cols.iter() {
                    sum -= mat[row as usize][*col as usize];
                }
                if sum == 0 {
                    num_rows += 1;
                }
            }
            return num_rows;
        }
        let mut max = 0;
        let max_cols = if mat.len() > 0 { mat[0].len() } else { 0 };
        for i in index..max_cols {
            cols.push_back(i);
            max = max.max(f(mat, num_cols, i + 1, prefix_sums, cols));
            cols.pop_back();
        }
        max
    }

    let mut prefix_sums = vec![0; matrix.len()];
    for i in 0..matrix.len() {
        let mut sum = 0;
        for j in 0..matrix[i].len() {
            sum += matrix[i][j];
        }
        prefix_sums[i] = sum;
    }
    f(
        &matrix,
        num_select as usize,
        0,
        &prefix_sums,
        &mut VecDeque::new(),
    )
}

fn main() {
    println!(
        "{}",
        maximum_rows(
            vec![vec![0, 0, 0], vec![1, 0, 1], vec![0, 1, 1], vec![0, 0, 1]],
            2
        )
    ); // 3
    println!(
        "{}",
        maximum_rows(
            vec![
                vec![0, 0, 0],
                vec![1, 0, 1],
                vec![0, 1, 1],
                vec![0, 0, 1],
                vec![1, 1, 1]
            ],
            2
        )
    ); // 3
    println!(
        "{}",
        maximum_rows(
            vec![
                vec![0, 0, 0],
                vec![1, 0, 1],
                vec![0, 1, 1],
                vec![0, 0, 1],
                vec![1, 1, 1]
            ],
            3
        )
    ); // 5
    println!("{}", maximum_rows(vec![vec![1], vec![0]], 1)); // 2
}
