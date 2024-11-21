// https://leetcode.com/problems/design-tic-tac-toe/description/
struct TicTacToe {
    n: i32,
    p1_rows: Vec<i32>,
    p1_cols: Vec<i32>,
    p1_diag1: i32,
    p1_diag2: i32,
    p2_rows: Vec<i32>,
    p2_cols: Vec<i32>,
    p2_diag1: i32,
    p2_diag2: i32,
}

impl TicTacToe {
    fn new(n: i32) -> Self {
        Self {
            n,
            p1_rows: vec![0; n as usize],
            p1_cols: vec![0; n as usize],
            p1_diag1: 0,
            p1_diag2: 0,
            p2_rows: vec![0; n as usize],
            p2_cols: vec![0; n as usize],
            p2_diag1: 0,
            p2_diag2: 0,
        }
    }

    fn make_a_move(&mut self, row: i32, col: i32, player: i32) -> i32 {
        if player == 1 {
            self.p1_rows[row as usize] += 1;
            self.p1_cols[col as usize] += 1;
            if self.is_diag1(row, col) {
                self.p1_diag1 += 1;
            }
            if self.is_diag2(row, col) {
                self.p1_diag2 += 1;
            }
        } else {
            self.p2_rows[row as usize] += 1;
            self.p2_cols[col as usize] += 1;
            if self.is_diag1(row, col) {
                self.p2_diag1 += 1;
            }
            if self.is_diag2(row, col) {
                self.p2_diag2 += 1;
            }
        }

        for i in 0..self.n {
            if self.p1_rows[i as usize] == self.n
                || self.p1_cols[i as usize] == self.n
                || self.p1_diag1 == self.n
                || self.p1_diag2 == self.n
            {
                return 1;
            }
            if self.p2_rows[i as usize] == self.n
                || self.p2_cols[i as usize] == self.n
                || self.p2_diag1 == self.n
                || self.p2_diag2 == self.n
            {
                return 2;
            }
        }
        0
    }

    fn is_diag1(&self, row: i32, col: i32) -> bool {
        row == col
    }

    fn is_diag2(&self, row: i32, col: i32) -> bool {
        row == self.n - col - 1
    }
}

fn main() {
    let mut tic_tac_toe = TicTacToe::new(3);
    println!("{}", tic_tac_toe.make_a_move(0, 0, 1)); // 0
    println!("{}", tic_tac_toe.make_a_move(0, 2, 2)); // 0
    println!("{}", tic_tac_toe.make_a_move(2, 2, 1)); // 0
    println!("{}", tic_tac_toe.make_a_move(1, 1, 2)); // 0
    println!("{}", tic_tac_toe.make_a_move(2, 0, 1)); // 0
    println!("{}", tic_tac_toe.make_a_move(1, 0, 2)); // 0
    println!("{}", tic_tac_toe.make_a_move(2, 1, 1)); // 1
}
