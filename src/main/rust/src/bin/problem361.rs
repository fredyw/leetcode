// https://leetcode.com/problems/bomb-enemy/description/
pub fn max_killed_enemies(grid: Vec<Vec<char>>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        max_killed_enemies(vec![
            vec!['0', 'E', '0', '0'],
            vec!['E', '0', 'W', 'E'],
            vec!['0', 'E', '0', '0']
        ])
    ); // 3
    println!(
        "{}",
        max_killed_enemies(vec![
            vec!['W', 'W', 'W'],
            vec!['0', '0', '0'],
            vec!['E', 'E', 'E']
        ])
    ); // 1
}
