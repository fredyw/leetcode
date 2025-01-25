// https://leetcode.com/problems/shortest-path-to-get-food/description/
pub fn get_food(grid: Vec<Vec<char>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        get_food(vec![
            vec!['X', 'X', 'X', 'X', 'X', 'X'],
            vec!['X', '*', 'O', 'O', 'O', 'X'],
            vec!['X', 'O', 'O', '#', 'O', 'X'],
            vec!['X', 'X', 'X', 'X', 'X', 'X']
        ])
    ); // 3
    println!(
        "{}",
        get_food(vec![
            vec!['X', 'X', 'X', 'X', 'X'],
            vec!['X', '*', 'X', 'O', 'X'],
            vec!['X', 'O', 'X', '#', 'X'],
            vec!['X', 'X', 'X', 'X', 'X']
        ])
    ); // -1
    println!(
        "{}",
        get_food(vec![
            vec!['X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'],
            vec!['X', '*', 'O', 'X', 'O', '#', 'O', 'X'],
            vec!['X', 'O', 'O', 'X', 'O', 'O', 'X', 'X'],
            vec!['X', 'O', 'O', 'O', 'O', '#', 'O', 'X'],
            vec!['X', 'X', 'X', 'X', 'X', 'X', 'X', 'X']
        ])
    ); // 6
}
