// https://leetcode.com/problems/make-a-square-with-the-same-color/description/
pub fn can_make_square(grid: Vec<Vec<char>>) -> bool {
    todo!()
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
