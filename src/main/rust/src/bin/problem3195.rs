// https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/description/
pub fn minimum_area(grid: Vec<Vec<i32>>) -> i32 {
    let mut min_col = i32::MAX;
    let mut max_col = i32::MIN;
    let mut min_row = i32::MAX;
    let mut max_row = i32::MIN;
    for row in 0..grid.len() {
        let mut found = false;
        for col in 0..grid[row].len() {
            if grid[row][col] == 1 {
                found = true;
                min_col = min_col.min(col as i32);
                max_col = max_col.max(col as i32);
            }
        }
        if found {
            min_row = min_row.min(row as i32);
            max_row = max_row.max(row as i32);
        }
    }
    (max_row - min_row + 1) * (max_col - min_col + 1)
}

fn main() {
    println!("{}", minimum_area(vec![vec![0, 1, 0], vec![1, 0, 1]])); // 6
    println!("{}", minimum_area(vec![vec![1, 0], vec![0, 0]])); // 1
    println!("{}", minimum_area(vec![vec![0, 0, 0], vec![1, 0, 1]])); // 3
    println!("{}", minimum_area(vec![vec![0, 1, 0], vec![1, 0, 0]])); // 4
    println!(
        "{}",
        minimum_area(vec![
            vec![0, 0, 0],
            vec![0, 0, 1],
            vec![0, 0, 0],
            vec![1, 0, 0]
        ])
    ); // 9
}
