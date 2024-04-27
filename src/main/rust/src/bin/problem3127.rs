// https://leetcode.com/problems/make-a-square-with-the-same-color/description/
pub fn can_make_square(grid: Vec<Vec<char>>) -> bool {
    fn count_white(grid: &Vec<Vec<char>>, row: usize, col: usize) -> u32 {
        if grid[row][col] == 'W' {
            1
        } else {
            0
        }
    }

    fn can_make_square(grid: &Vec<Vec<char>>, row: usize, col: usize) -> bool {
        let total_white_count = count_white(&grid, row, col)
            + count_white(&grid, row, col + 1)
            + count_white(&grid, row + 1, col)
            + count_white(&grid, row + 1, col + 1);
        total_white_count <= 1 || total_white_count >= 3
    }

    can_make_square(&grid, 0, 0)
        || can_make_square(&grid, 0, 1)
        || can_make_square(&grid, 1, 0)
        || can_make_square(&grid, 1, 1)
}

fn main() {
    println!(
        "{}",
        can_make_square(vec![
            vec!['B', 'W', 'B'],
            vec!['B', 'W', 'W'],
            vec!['B', 'W', 'B']
        ])
    ); // true
    println!(
        "{}",
        can_make_square(vec![
            vec!['B', 'W', 'B'],
            vec!['W', 'B', 'W'],
            vec!['B', 'W', 'B']
        ])
    ); // false
    println!(
        "{}",
        can_make_square(vec![
            vec!['B', 'W', 'B'],
            vec!['B', 'W', 'W'],
            vec!['B', 'W', 'W']
        ])
    ); // true
}
