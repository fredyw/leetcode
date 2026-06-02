// https://leetcode.com/problems/number-of-spaces-cleaning-robot-cleaned/description/
pub fn number_of_clean_rooms(room: Vec<Vec<i32>>) -> i32 {
    enum Direction {
        Left,
        Right,
        Up,
        Down,
    }

    fn traverse(
        room: &Vec<Vec<i32>>,
        row: isize,
        col: isize,
        direction: Direction,
        visited: &mut Vec<Vec<bool>>,
    ) -> i32 {
        let num_rows = room.len() as isize;
        let num_cols = if num_rows > 0 { room[0].len() } else { 0 } as isize;
        if num_rows < 0
            || num_cols < 0
            || num_rows == row
            || num_cols == col
            || visited[row as usize][col as usize]
        {
            return 0;
        }
        visited[row as usize][col as usize] = true;
        match direction {
            Direction::Left => {
                if col - 1 < 0 {
                    traverse(room, row - 1, col, Direction::Up, visited)
                } else {
                    traverse(room, row, col - 1, direction, visited)
                }
            }
            Direction::Right => {
                if col + 1 == num_cols {
                    traverse(room, row + 1, col, Direction::Down, visited)
                } else {
                    traverse(room, row, col + 1, direction, visited)
                }
            }
            Direction::Up => {
                if row - 1 < 0 {
                    traverse(room, row, col + 1, Direction::Right, visited)
                } else {
                    traverse(room, row - 1, col, direction, visited)
                }
            }
            Direction::Down => {
                if row + 1 == num_rows {
                    traverse(room, row, col - 1, Direction::Left, visited)
                } else {
                    traverse(room, row + 1, col, direction, visited)
                }
            }
        }
    }

    let num_rows = room.len();
    let num_cols = if num_rows > 0 { room[0].len() } else { 0 };
    traverse(
        &room,
        0,
        0,
        Direction::Right,
        &mut vec![vec![false; num_cols]; num_rows],
    )
}

fn main() {
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 0, 0], vec![1, 1, 0], vec![0, 0, 0]])
    ); // 7
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 1, 0], vec![1, 0, 0], vec![0, 0, 0]])
    ); // 1
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 0, 0], vec![0, 0, 0], vec![0, 0, 0]])
    ); // 0
    println!(
        "{}",
        number_of_clean_rooms(vec![vec![0, 0, 0], vec![1, 0, 0], vec![0, 0, 0]])
    ); // 7
}
