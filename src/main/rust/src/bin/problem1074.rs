// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
pub fn num_submatrix_sum_target(matrix: Vec<Vec<i32>>, target: i32) -> i32 {
    let mut answer = 0;
    let max_rows = matrix.len();
    let max_cols = if max_rows > 0 { matrix[0].len() } else { 0 };
    let mut prefix_sums = vec![vec![0; max_cols]; max_rows];
    for row in 0..max_rows {
        let mut prefix_sum = 0;
        for col in 0..max_cols {
            prefix_sum += matrix[row][col];
            prefix_sums[row][col] = prefix_sum
                + if row > 0 {
                    prefix_sums[row - 1][col]
                } else {
                    0
                };
        }
    }
    for row1 in 0..max_rows {
        for col1 in 0..max_cols {
            for row2 in row1..max_rows {
                for col2 in col1..max_cols {
                    let a = if row1 > 0 {
                        prefix_sums[row1 - 1][col2]
                    } else {
                        0
                    };
                    let b = if col1 > 0 {
                        prefix_sums[row2][col1 - 1]
                            - if row1 > 0 {
                                prefix_sums[row1 - 1][col1 - 1]
                            } else {
                                0
                            }
                    } else {
                        0
                    };
                    let sum = prefix_sums[row2][col2] - a - b;
                    if sum == target {
                        answer += 1;
                    }
                }
            }
        }
    }
    answer
}

fn main() {
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![0, 0, 0], vec![1, -1, 1], vec![0, 1, 0]], 0)
    ); // 14
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![0, 1, 0], vec![1, 1, 1], vec![0, 1, 0]], 0)
    ); // 4
    println!(
        "{}",
        num_submatrix_sum_target(vec![vec![1, -1], vec![-1, 1]], 0)
    ); // 5
    println!("{}", num_submatrix_sum_target(vec![vec![904]], 0)); // 0
    println!(
        "{}",
        num_submatrix_sum_target(
            vec![
                vec![0, 0, 0, 1, 1],
                vec![1, 1, 1, 0, 1],
                vec![1, 1, 1, 1, 0],
                vec![0, 0, 0, 1, 0],
                vec![0, 0, 0, 1, 1]
            ],
            0
        )
    ); // 28
}
