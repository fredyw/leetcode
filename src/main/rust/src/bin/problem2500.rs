// https://leetcode.com/problems/delete-greatest-value-in-each-row/
pub fn delete_greatest_value(mut grid: Vec<Vec<i32>>) -> i32 {
    for row in grid.iter_mut() {
        row.sort_by(|a, b| b.cmp(a));
    }
    let mut answer = 0;
    let num_cols = grid[0].len();
    for col in 0..num_cols {
        let mut max = 0;
        for row in grid.iter() {
            max = max.max(row[col]);
        }
        answer += max;
    }
    answer
}

fn main() {
    println!(
        "{}",
        delete_greatest_value(vec![vec![1, 2, 4], vec![3, 3, 1]])
    ); // 8
    println!("{}", delete_greatest_value(vec![vec![10]])); // 10
}
