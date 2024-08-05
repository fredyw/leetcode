// https://leetcode.com/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/description/
pub fn min_flips(grid: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        min_flips(vec![vec![1, 0, 0], vec![0, 0, 0], vec![0, 0, 1]])
    ); // 2
    println!("{}", min_flips(vec![vec![0, 1], vec![0, 1], vec![0, 0]])); // 1
    println!("{}", min_flips(vec![vec![1], vec![0]])); // 0
}
