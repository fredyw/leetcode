// https://leetcode.com/problems/design-tic-tac-toe/description/
struct TicTacToe {
    n: i32,
    rows: Vec<i32>,
    cols: Vec<i32>,
    diag1: i32,
    diag2: i32,
}

impl TicTacToe {
    fn new(n: i32) -> Self {
        Self {
            n,
            rows: vec![0; n as usize],
            cols: vec![0; n as usize],
            diag1: 0,
            diag2: 0,
        }
    }

    fn make_a_move(&mut self, row: i32, col: i32, player: i32) -> i32 {
        let val = if player == 1 { 1 } else { -1 };
        self.rows[row as usize] += val;
        self.cols[col as usize] += val;
        if self.is_diag1(row, col) {
            self.diag1 += val;
        }
        if self.is_diag2(row, col) {
            self.diag2 += val;
        }

        if self.rows[row as usize] == self.n
            || self.cols[col as usize] == self.n
            || self.diag1 == self.n
            || self.diag2 == self.n
        {
            1
        } else if self.rows[row as usize] == -self.n
            || self.cols[col as usize] == -self.n
            || self.diag1 == -self.n
            || self.diag2 == -self.n
        {
            2
        } else {
            0
        }
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
