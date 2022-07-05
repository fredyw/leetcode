// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
pub fn min_flips(mat: Vec<Vec<i32>>) -> i32 {
    todo!()
}

fn main() {
    println!("{}", min_flips(vec![vec![0, 0], vec![0, 1]])); // 3
    println!("{}", min_flips(vec![vec![0]])); // 0
    println!("{}", min_flips(vec![vec![1, 0, 0], vec![1, 0, 0]])); // -1
    println!(
        "{}",
        min_flips(vec![vec![0, 0, 1], vec![0, 1, 0], vec![1, 0, 1]])
    ); // 4
}
