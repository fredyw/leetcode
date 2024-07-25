// https://leetcode.com/problems/candy-crush/description/
pub fn candy_crush(mut board: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
    fn candy_crush(board: &mut Vec<Vec<i32>>) -> bool {
        let num_rows = board.len();
        let num_cols = if num_rows > 0 { board[0].len() } else { 0 };
        let mut to_be_crushed: Vec<(usize, usize)> = vec![];
        for i in 0..num_rows {
            let mut j = 0;
            while j < num_cols {
                let mut k = j;
                let mut count = 0;
                if board[i][j] != 0 {
                    while k < num_cols && board[i][j] == board[i][k] {
                        count += 1;
                        k += 1;
                    }
                    if count > 2 {
                        for l in j..k {
                            to_be_crushed.push((i, l));
                        }
                    }
                    j = k;
                } else {
                    j += 1;
                }
            }
        }

        for i in 0..num_cols {
            let mut j = 0;
            while j < num_rows {
                let mut k = j;
                let mut count = 0;
                if board[j][i] != 0 {
                    while k < num_rows && board[j][i] == board[k][i] {
                        count += 1;
                        k += 1;
                    }
                    if count > 2 {
                        for l in j..k {
                            to_be_crushed.push((l, i));
                        }
                    }
                    j = k;
                } else {
                    j += 1;
                }
            }
        }

        for (row, col) in to_be_crushed.iter() {
            board[*row][*col] = 0;
        }

        for i in 0..num_cols {
            let mut j = 0;
            while j < num_rows {
                if board[j][i] == 0 {
                    let mut k = j;
                    let mut n = 0;
                    while k < num_rows && board[k][i] == 0 {
                        n += 1;
                        k += 1;
                    }
                    let mut l = j as isize - 1;
                    while l >= 0 {
                        let val = board[l as usize][i];
                        board[l as usize][i] = 0;
                        board[l as usize + n as usize][i] = val;
                        l -= 1;
                    }
                    j = k;
                } else {
                    j += 1;
                }
            }
        }

        !to_be_crushed.is_empty()
    }

    while candy_crush(&mut board) {}
    board
}

fn main() {
    // [[0,0,0,0,0],
    //  [0,0,0,0,0],
    //  [0,0,0,0,0],
    //  [110,0,0,0,114],
    //  [210,0,0,0,214],
    //  [310,0,0,113,314],
    //  [410,0,0,213,414],
    //  [610,211,112,313,614],
    //  [710,311,412,613,714],
    //  [810,411,512,713,1014]]
    println!(
        "{:?}",
        candy_crush(vec![
            vec![110, 5, 112, 113, 114],
            vec![210, 211, 5, 213, 214],
            vec![310, 311, 3, 313, 314],
            vec![410, 411, 412, 5, 414],
            vec![5, 1, 512, 3, 3],
            vec![610, 4, 1, 613, 614],
            vec![710, 1, 2, 713, 714],
            vec![810, 1, 2, 1, 1],
            vec![1, 1, 2, 2, 2],
            vec![4, 1, 4, 4, 1014]
        ])
    );
    // // [[1,3,0,0,0],
    // //  [3,4,0,5,2],
    // //  [3,2,0,3,1],
    // //  [2,4,0,5,2],
    // //  [1,4,3,1,1]]
    // println!(
    //     "{:?}",
    //     candy_crush(vec![
    //         vec![1, 3, 5, 5, 2],
    //         vec![3, 4, 3, 3, 1],
    //         vec![3, 2, 4, 5, 2],
    //         vec![2, 4, 4, 5, 5],
    //         vec![1, 4, 4, 1, 1]
    //     ])
    // );
}
