// https://leetcode.com/problems/the-knights-tour/description/
pub fn tour_of_knight(m: i32, n: i32, r: i32, c: i32) -> Vec<Vec<i32>> {
    fn possible_moves(row: i32, col: i32) -> Vec<(i32, i32)> {
        vec![
            (row - 2, col - 1),
            (row - 2, col + 1),
            (row + 2, col - 1),
            (row + 2, col + 1),
            (row - 1, col - 2),
            (row + 1, col - 2),
            (row - 1, col + 2),
            (row + 1, col - 2),
        ]
    }

    fn tour_of_knight(
        board: &mut Vec<Vec<i32>>,
        row: i32,
        col: i32,
        visited: &mut Vec<Vec<bool>>,
        count: i32,
    ) {
        let num_rows = board.len() as i32;
        let num_cols = if num_rows > 0 { board[0].len() } else { 0 } as i32;
        if count == num_rows * num_cols {
            println!("{:?}", board);
            return;
        }
        if row < 0
            || row >= num_rows
            || col < 0
            || col >= num_cols
            || visited[row as usize][col as usize]
        {
            return;
        }
        visited[row as usize][col as usize] = true;
        let prev = board[row as usize][col as usize];
        board[row as usize][col as usize] = count;
        for v in board.iter() {
            println!("{:?}", v);
        }
        println!("");
        for (r, c) in possible_moves(row, col) {
            tour_of_knight(board, r, c, visited, count + 1);
        }
        board[row as usize][col as usize] = prev;
    }

    let mut answer: Vec<Vec<i32>> = vec![vec![-1; n as usize]; m as usize];
    tour_of_knight(
        &mut answer,
        r,
        c,
        &mut vec![vec![false; n as usize]; m as usize],
        0,
    );
    answer
}

fn main() {
    // println!("{:?}", tour_of_knight(1, 1, 0, 0)); // [[0]]
    println!("{:?}", tour_of_knight(3, 4, 0, 0)); // [[0,3,6,9],[11,8,1,4],[2,5,10,7]]
}
