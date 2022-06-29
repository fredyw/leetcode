// https://leetcode.com/problems/check-if-move-is-legal/
pub fn check_move(board: Vec<Vec<char>>, r_move: i32, c_move: i32, color: char) -> bool {
    fn opposite(c: char) -> char {
        if c == 'W' {
            'B'
        } else {
            'W'
        }
    }

    fn check(
        board: &Vec<Vec<char>>,
        row: i32,
        col: i32,
        color: char,
        row_fn: fn(i32) -> i32,
        col_fn: fn(i32) -> i32,
    ) -> bool {
        let n = 8;
        let mut r = row;
        let mut c = col;
        let mut count = 0;
        while r >= 0
            && r < n
            && c >= 0
            && c < n
            && &board[r as usize][c as usize] == &opposite(color)
        {
            count += 1;
            r = row_fn(r);
            c = col_fn(c);
        }
        count >= 1 && r >= 0 && r < n && c >= 0 && c < n && &board[r as usize][c as usize] == &color
    }

    let n = 8;
    // Top
    if check(&board, r_move - 1, c_move, color, |r| r - 1, |c| c) {
        return true;
    }
    // Upper right diagonal
    if check(&board, r_move - 1, c_move + 1, color, |r| r - 1, |c| c + 1) {
        return true;
    }
    // Right
    if check(&board, r_move, c_move + 1, color, |r| r, |c| c + 1) {
        return true;
    }
    // Lower right diagonal
    if check(&board, r_move + 1, c_move + 1, color, |r| r + 1, |c| c + 1) {
        return true;
    }
    // Bottom
    if check(&board, r_move + 1, c_move, color, |r| r + 1, |c| c) {
        return true;
    }
    // Lower left diagonal
    if check(&board, r_move + 1, c_move - 1, color, |r| r + 1, |c| c - 1) {
        return true;
    }
    // Left
    if check(&board, r_move, c_move - 1, color, |r| r, |c| c - 1) {
        return true;
    }
    // Upper left diagonal
    if check(&board, r_move - 1, c_move - 1, color, |r| r - 1, |c| c - 1) {
        return true;
    }
    false
}

fn main() {
    println!(
        "{}",
        check_move(
            vec![
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.'],
                vec!['W', 'B', 'B', '.', 'W', 'W', 'W', 'B'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.']
            ],
            4,
            3,
            'B'
        )
    ); // true
    println!(
        "{}",
        check_move(
            vec![
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.'],
                vec!['W', 'B', 'B', '.', 'B', 'W', 'W', 'B'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.']
            ],
            4,
            3,
            'B'
        )
    ); // true
    println!(
        "{}",
        check_move(
            vec![
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['W', 'B', 'B', '.', 'B', 'W', 'W', 'B'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'B', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', '.', '.', '.', '.']
            ],
            4,
            3,
            'B'
        )
    ); // false
    println!(
        "{}",
        check_move(
            vec![
                vec!['.', '.', '.', '.', '.', '.', '.', '.'],
                vec!['.', 'B', '.', '.', 'W', '.', '.', '.'],
                vec!['.', '.', 'W', '.', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', 'B', '.', '.', '.'],
                vec!['.', '.', '.', '.', '.', '.', '.', '.'],
                vec!['.', '.', '.', '.', 'B', 'W', '.', '.'],
                vec!['.', '.', '.', '.', '.', '.', 'W', '.'],
                vec!['.', '.', '.', '.', '.', '.', '.', 'B']
            ],
            4,
            4,
            'W'
        )
    ); // false
    println!(
        "{}",
        check_move(
            vec![
                vec!['.', '.', '.', '.', '.', '.', '.', '.'],
                vec!['.', 'B', '.', '.', 'W', '.', '.', '.'],
                vec!['.', '.', 'W', '.', '.', '.', '.', '.'],
                vec!['.', '.', '.', 'W', 'B', '.', '.', '.'],
                vec!['.', '.', '.', '.', '.', '.', '.', '.'],
                vec!['.', '.', '.', '.', 'B', 'W', '.', '.'],
                vec!['.', '.', '.', '.', '.', '.', 'W', '.'],
                vec!['.', '.', '.', '.', '.', '.', '.', 'B']
            ],
            4,
            4,
            'B'
        )
    ); // true
}
