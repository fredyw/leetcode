// https://leetcode.com/problems/the-knights-tour/description/
pub fn tour_of_knight(m: i32, n: i32, r: i32, c: i32) -> Vec<Vec<i32>> {
    fn tour_of_knight(board: &mut Vec<Vec<i32>>, row: i32, col: i32, visited: &mut Vec<Vec<bool>>) {
        let num_rows = board.len() as i32;
        let num_cols = if num_rows > 0 { board[0].len() } else { 0 } as i32;
        if row < 0
            || row >= num_rows
            || col < 0
            || col >= num_cols
            || visited[row as usize][col as usize]
        {
            return;
        }
    }

    let mut answer: Vec<Vec<i32>> = vec![vec![-1; n as usize]; m as usize];
    tour_of_knight(
        &mut answer,
        r,
        c,
        &mut vec![vec![false; n as usize]; m as usize],
    );
    answer
}

fn main() {
    println!("{:?}", tour_of_knight(1, 1, 0, 0)); // [[0]]
    println!("{:?}", tour_of_knight(3, 4, 0, 0)); // [[0,3,6,9],[11,8,1,4],[2,5,10,7]]
}
