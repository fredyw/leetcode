use std::cmp;

pub fn max_matrix_sum(matrix: Vec<Vec<i32>>) -> i64 {
    let mut sum: i64 = 0;
    let mut negative_count = 0;
    let mut smallest = i32::MAX;
    for i in 0..matrix.len() {
        for j in 0..matrix[0].len() {
            sum += i64::abs(matrix[i][j] as i64);
            negative_count += if matrix[i][j] < 0 { 1 } else { 0 };
            smallest = cmp::min(smallest, i32::abs(matrix[i][j]));
        }
    }
    if negative_count % 2 == 0 {
        sum
    } else {
        sum - (smallest as i64 * 2)
    }
}

fn main() {
    println!("{}", max_matrix_sum(vec![vec![1, -1], vec![-1, 1]])); // 4
    println!(
        "{}",
        max_matrix_sum(vec![vec![1, 2, 3], vec![-1, -2, -3], vec![1, 2, 3]])
    ); // 16
    println!(
        "{}",
        max_matrix_sum(vec![
            vec![1, 2, 3, 4],
            vec![-1, -2, -3, 4],
            vec![1, 2, 3, 4],
            vec![1, 2, 3, 4]
        ])
    ); // 38
    println!(
        "{}",
        max_matrix_sum(vec![
            vec![1, 2, 3, 4],
            vec![-1, -2, -3, -4],
            vec![1, 2, 3, 4],
            vec![1, 2, 3, 4]
        ])
    ); // 40
    println!(
        "{}",
        max_matrix_sum(vec![
            vec![1, 2, 3, 4, 5],
            vec![1, 2, 3, 4, 5],
            vec![1, 2, -3, 4, 5],
            vec![1, 2, 3, 4, 5],
            vec![1, 2, 3, 4, 5],
        ])
    ); // 73
}
