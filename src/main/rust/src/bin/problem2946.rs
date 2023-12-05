// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/
pub fn are_similar(mat: Vec<Vec<i32>>, k: i32) -> bool {
    let m = mat.len();
    let n = if m > 0 { mat[0].len() } else { 0 };
    let k = k % n as i32;
    let mut shifted_mat = mat.clone();
    for row in 0..m {
        for col in 0..n {
            if row % 2 == 0 {
                // left
                // println!("new_col: {}", n + ((col as i32 - 1) % k as usize));
                shifted_mat[row][col] = mat[row][col + (col as i32 - k) as usize % n];
            } else {
                // right
                shifted_mat[row][col] = mat[row][(col + k as usize) % n];
            }
        }
    }
    for v in shifted_mat.iter() {
        println!("{:?}", v);
    }
    mat == shifted_mat
}

fn main() {
    println!(
        "{}",
        are_similar(
            vec![vec![1, 2, 1, 2], vec![5, 5, 5, 5], vec![6, 3, 6, 3]],
            2
        )
    ); // true
       // println!("{}", are_similar(vec![vec![2, 2], vec![2, 2]], 3)); // true
       // println!("{}", are_similar(vec![vec![1, 2]], 1)); // false
}
