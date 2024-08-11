// https://leetcode.com/problems/snake-in-matrix/description/
pub fn final_position_of_snake(n: i32, commands: Vec<String>) -> i32 {
    todo!()
}

fn main() {
    println!(
        "{}",
        final_position_of_snake(2, vec!["RIGHT".to_string(), "DOWN".to_string()])
    ); // 3
    println!(
        "{}",
        final_position_of_snake(
            3,
            vec!["DOWN".to_string(), "RIGHT".to_string(), "UP".to_string()]
        )
    ); // 1
}
