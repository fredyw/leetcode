// https://leetcode.com/problems/check-knight-tour-configuration/
pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
    todo!()
}

fn main() {
    println!(
        "{}",
        check_valid_grid(vec![
            vec![0, 11, 16, 5, 20],
            vec![17, 4, 19, 10, 15],
            vec![12, 1, 8, 21, 6],
            vec![3, 18, 23, 14, 9],
            vec![24, 13, 2, 7, 22]
        ])
    ); // true
    println!(
        "{}",
        check_valid_grid(vec![vec![0, 3, 6], vec![5, 8, 1], vec![2, 7, 4]])
    ); // false
}
