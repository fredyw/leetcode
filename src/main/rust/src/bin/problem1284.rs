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

    fn flip(mat: &mut Vec<Vec<i32>>, row: i32, col: i32) {
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
    }

    fn min_flips(mat: &mut Vec<Vec<i32>>, row: i32, col: i32, visited: &mut Vec<Vec<bool>>) -> i32 {
        let max_row = mat.len() as i32;
        let max_col = if max_row > 0 { mat[0].len() } else { 0 } as i32;
        if row < 0 || row == max_row || col < 0 || col == max_col {
            return i32::MAX;
        }
        if visited[row as usize][col as usize] {
            return i32::MAX;
        }
        if is_binary(mat) {
            return 0;
        }
        flip(mat, row, col);
        println!("{} {} -> {:?}", row, col, mat);
        visited[row as usize][col as usize] = true;
        let mut min = i32::MAX;
        for (r, c) in [(-1, 0), (0, 1), (1, 0), (0, -1)] {
            let m = min_flips(mat, row + r, col + c, visited);
            if m != i32::MAX {
                min = min.min(m + 1);
            }
        }
        flip(mat, row, col);
        visited[row as usize][col as usize] = false;
        min
    }

    let mut answer = i32::MAX;
    let max_row = mat.len();
    let max_col = if max_row > 0 { mat[0].len() } else { 0 };
    let mut mat = mat.clone();
    let mut visited = vec![vec![false; max_col]; max_row];
    for i in 0..mat.len() {
        for j in 0..mat[0].len() {
            answer = answer.min(min_flips(&mut mat, i as i32, j as i32, &mut visited));
        }
    }
    if answer == i32::MAX {
        -1
    } else {
        answer
    }
}

fn main() {
    // println!("{}", min_flips(vec![vec![0, 0], vec![0, 1]])); // 3
    // println!("{}", min_flips(vec![vec![0]])); // 0
    // println!("{}", min_flips(vec![vec![1, 0, 0], vec![1, 0, 0]])); // -1
    println!(
        "{}",
        min_flips(vec![vec![0, 0, 1], vec![0, 1, 0], vec![1, 0, 1]])
    ); // 4
}
