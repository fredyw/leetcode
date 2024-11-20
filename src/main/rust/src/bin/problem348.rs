// https://leetcode.com/problems/design-tic-tac-toe/description/
struct TicTacToe {}

impl TicTacToe {
    fn new(n: i32) -> Self {
        Self {}
    }

    fn make_a_move(&mut self, row: i32, col: i32, player: i32) -> i32 {
        todo!()
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
