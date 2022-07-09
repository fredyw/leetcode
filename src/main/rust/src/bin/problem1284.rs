// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/
pub fn min_flips(mat: Vec<Vec<i32>>) -> i32 {
    fn is_binary(mat: &Vec<Vec<i32>>) -> bool {
        for i in 0..mat.len() {
            for j in 0..mat[i].len() {
                if mat[i][j] != 0 {
                    return false;
                }
            }
        }
        true
    }

    fn flip(mat: &mut Vec<Vec<i32>>, row: i32, col: i32) -> &Vec<Vec<i32>> {
        let max_row = mat.len() as i32;
        let max_col = if max_row > 0 { mat[0].len() } else { 0 } as i32;
        mat[row as usize][col as usize] ^= 1;
        if row - 1 >= 0 {
            mat[(row - 1) as usize][col as usize] ^= 1;
        }
        if col - 1 >= 0 {
            mat[row as usize][(col - 1) as usize] ^= 1;
        }
        if row + 1 < max_row {
            mat[(row + 1) as usize][col as usize] ^= 1;
        }
        if col + 1 < max_col {
            mat[row as usize][(col + 1) as usize] ^= 1;
        }
        mat
    }

    fn min_flips(mat: &mut Vec<Vec<i32>>, row: i32, col: i32) -> i32 {
        let max_row = mat.len() as i32;
        let max_col = if max_row > 0 { mat[0].len() } else { 0 } as i32;
        let mut row = row;
        let mut col = col;
        if col == max_col {
            row += 1;
            col = 0;
        }
        if row == max_row {
            if is_binary(mat) {
                return 0;
            }
            return i32::MAX;
        }
        let not_flipped = min_flips(mat, row, col + 1);
        let mut min = not_flipped;
        flip(mat, row, col);
        let flipped = min_flips(mat, row, col + 1);
        if flipped != i32::MAX {
            min = min.min(flipped + 1);
        }
        flip(mat, row, col);
        min
    }

    let mut mat = mat.clone();
    let answer = min_flips(&mut mat, 0, 0);
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
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
