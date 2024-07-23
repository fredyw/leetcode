// https://leetcode.com/problems/lonely-pixel-i/description/
pub fn find_lonely_pixel(picture: Vec<Vec<char>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        find_lonely_pixel(vec![vec!['W', 'W', 'B'], vec!['W', 'B', 'W']])
    ); // 3
    println!(
        "{}",
        find_lonely_pixel(vec![
            vec!['B', 'B', 'B'],
            vec!['B', 'B', 'W'],
            vec!['B', 'B', 'B']
        ])
    ); // 0
}
